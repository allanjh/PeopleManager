package com.allanjhonny.peoplemanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allanjhonny.peoplemanager.domain.Cidade;
import com.allanjhonny.peoplemanager.repositories.CidadeRepository;
import com.allanjhonny.peoplemanager.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade find(Integer id) {
		Optional<Cidade> resposta = cidadeRepository.findById(id);
		return resposta.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}

}
