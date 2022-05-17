package com.allanjhonny.peoplemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.allanjhonny.peoplemanager.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	
	@Transactional(readOnly=true)
	Usuario findByNomeUsuario(String nomeUsuario);
}
