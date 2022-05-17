package com.allanjhonny.peoplemanager.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.allanjhonny.peoplemanager.domain.enums.PerfilUsuario;

public class UserSS implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nomeUsuario;
	private String senhaUsuario;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSS() {
		
	}
	
	public UserSS(Integer id, String nomeUsuario, String senhaUsuario,
			PerfilUsuario perfilUsuario) {
		super();
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.senhaUsuario = senhaUsuario;
		this.authorities = Arrays.asList(new SimpleGrantedAuthority(perfilUsuario.getDescricao()));
	}

	public Integer getId() {
		return id;
	}
		
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senhaUsuario;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nomeUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
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
