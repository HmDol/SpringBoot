package com.example.demo.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.demo.member.Member2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityMember implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String pwd;
	private Collection<? extends GrantedAuthority> authorities;
	
	public SecurityMember(Member2 m) {
		this.id = m.getId();
		this.pwd = m.getPwd();
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority("user"));
		this.authorities = list;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return pwd;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
