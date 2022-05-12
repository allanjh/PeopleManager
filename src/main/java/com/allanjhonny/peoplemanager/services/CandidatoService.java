package com.allanjhonny.peoplemanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allanjhonny.peoplemanager.domain.Candidato;
import com.allanjhonny.peoplemanager.dto.CandidatoDTO;
import com.allanjhonny.peoplemanager.repositories.CandidatoRepository;
import com.allanjhonny.peoplemanager.services.exceptions.ObjectNotFoundException;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public Candidato find(Integer id) {
		Optional<Candidato> resposta = candidatoRepository.findById(id);
		return resposta.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Candidato.class.getName()));
	}
	
	public Candidato insert(Candidato obj) {
		obj.setId(null);
		return candidatoRepository.save(obj);
	}
	
	public Candidato update(Candidato obj) {
		Candidato newObj = find(obj.getId());
		updateData(newObj, obj);
		return candidatoRepository.save(obj);
	}
	
	private void updateData(Candidato newObj, Candidato obj) {
		newObj.setNome(obj.getNome());
		newObj.setNumero(obj.getNumero());
		newObj.setEficienciaDeAngariacao(obj.getEficienciaDeAngariacao());
		
	}
	
	public Candidato fromDTO(CandidatoDTO objDto) {
		return new Candidato(objDto.getId(), objDto.getNome(), objDto.getNumeroCandidato(), objDto.getEficienciaDeAngariacao());
	}

}
