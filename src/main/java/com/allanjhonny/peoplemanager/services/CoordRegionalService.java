package com.allanjhonny.peoplemanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allanjhonny.peoplemanager.domain.Candidato;
import com.allanjhonny.peoplemanager.domain.CoordenadorRegional;
import com.allanjhonny.peoplemanager.dto.CoordenadorRegionalDTO;
import com.allanjhonny.peoplemanager.repositories.CoordRegionalRepository;
import com.allanjhonny.peoplemanager.services.exceptions.ObjectNotFoundException;

@Service
public class CoordRegionalService {
	
	@Autowired
	private CoordRegionalRepository coordRegionalRepository;
	
	@Autowired
	private CandidatoService candidatoService;
	
	public CoordenadorRegional find(Integer id) {
		Optional<CoordenadorRegional> resposta = coordRegionalRepository.findById(id);
		return resposta.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + CoordenadorRegional.class.getName()));
	}
	
	public CoordenadorRegional insert(CoordenadorRegional obj) {
		obj.setId(null);
		return coordRegionalRepository.save(obj);
	}
	
	public CoordenadorRegional update(CoordenadorRegional obj) {
		CoordenadorRegional newObj = find(obj.getId());
		updateData(newObj, obj);
		return coordRegionalRepository.save(obj);
	}
	
	private void updateData(CoordenadorRegional newObj, CoordenadorRegional obj) {
		newObj.setNome(obj.getNome());
		newObj.setTelefone(obj.getTelefone());
	}
	
	public CoordenadorRegional fromDTO(CoordenadorRegionalDTO objDto) {
		Candidato candidato = candidatoService.find(objDto.getCandidato());
		return new CoordenadorRegional(objDto.getId(), objDto.getNome(), objDto.getTelefone(), candidato);
	}

}
