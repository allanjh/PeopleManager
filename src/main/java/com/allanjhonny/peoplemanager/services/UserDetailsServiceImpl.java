package com.allanjhonny.peoplemanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.allanjhonny.peoplemanager.domain.Usuario;
import com.allanjhonny.peoplemanager.repositories.UsuarioRepository;
import com.allanjhonny.peoplemanager.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepo;
	
	@Override
	public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepo.findByNomeUsuario(nomeUsuario);
		if (usuario == null) {
			throw new UsernameNotFoundException(nomeUsuario);
		}
		return new UserSS(usuario.getId(),usuario.getNomeUsuario(), usuario.getSenhaUsuario(),usuario.getPerfilUsuario());
	}

}
