package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.member.Member2;
import com.example.demo.member.MemberDao;
import com.example.demo.member.MemberDto;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	MemberDao dao;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

		Member2 m = dao.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("not found loginId : " + id));
		System.out.println("detail service:"+m);
		return new SecurityMember(m);
	}
}