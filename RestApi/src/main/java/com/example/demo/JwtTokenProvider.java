package com.example.demo;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.member.MemberDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

//인증 완료 후 토큰 생성해서 주는 클래스
@Component
public class JwtTokenProvider {
	//토큰의 유효시간 설정
   private final Long expiredTime = 1000 * 60L * 60L * 1L; // 유효시간 1시간
   Key key = Keys.hmacShaKeyFor("qwerqwersdfdsdgfsdgsdgfsfgsgafFSGHDFHJGFJGDFHSFGHSGFGDHFGJFGHJGFHJFHSFHDFGJHGJSFHSDHDHJFGHJGFHSFHGSFGHDFfgsdf".getBytes(StandardCharsets.UTF_8));

   public String generateJwtToken(MemberDto member) {
       Date now = new Date();
       return Jwts.builder().setSubject(member.getId()) // 보통 username
               .setHeader(createHeader()).setClaims(createClaims(member)) // 클레임, 토큰에 포함될 정보
               .setExpiration(new Date(now.getTime() + expiredTime)) // 만료일
               .signWith(key, SignatureAlgorithm.HS256).compact();
   }

   private Map<String, Object> createHeader() {
       Map<String, Object> header = new HashMap<>();
       header.put("typ", "JWT");
       header.put("alg", "HS256"); // 해시 256 사용하여 암호화
       header.put("regDate", System.currentTimeMillis());
       return header;
   }

   private Map<String, Object> createClaims(MemberDto member) {
       Map<String, Object> claims = new HashMap<>();
       claims.put("username", member.getId()); // username
     //claims.put("roles", member.getType()); // 인가정보
       return claims;
   }

   private Claims getClaims(String token) {
       return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
   }

   public String getUsernameFromToken(String token) {
       return (String) getClaims(token).get("username");
   }

//   public int getRoleFromToken(String token) {
//       return (int) getClaims(token).get("roles");
//   }

}
