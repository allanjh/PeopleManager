package com.allanjhonny.peoplemanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.allanjhonny.peoplemanager.domain.Usuario;
import com.allanjhonny.peoplemanager.domain.enums.PerfilUsuario;
import com.allanjhonny.peoplemanager.dto.UsuarioDTO;
import com.allanjhonny.peoplemanager.repositories.UsuarioRepository;
import com.allanjhonny.peoplemanager.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public Usuario find(Integer id) {
		Optional<Usuario> resposta = usuarioRepository.findById(id);
		return resposta.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj.setSenhaUsuario(pe.encode(obj.getSenhaUsuario()));
		return usuarioRepository.save(obj);
	}
	
	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return usuarioRepository.save(obj);
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNomeUsuario(obj.getNomeUsuario());
		newObj.setSenhaUsuario(obj.getSenhaUsuario());
		newObj.setPerfilUsuario(obj.getPerfilUsuario());
		
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNomeUsuario(), objDto.getSenhaUsuario(), PerfilUsuario.toEnum(objDto.getPerfilUsuario()));
	}

}
