package com.allanjhonny.peoplemanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allanjhonny.peoplemanager.domain.CoordenadorLocal;
import com.allanjhonny.peoplemanager.domain.CoordenadorRegional;
import com.allanjhonny.peoplemanager.dto.CoordenadorLocalDTO;
import com.allanjhonny.peoplemanager.repositories.CoordLocalRepository;
import com.allanjhonny.peoplemanager.services.exceptions.ObjectNotFoundException;

@Service
public class CoordLocalService {

	@Autowired
	private CoordLocalRepository coordLocalRepository;
	
	@Autowired
	private CoordRegionalService coordRegionalService;

	public CoordenadorLocal find(Integer id) {
		Optional<CoordenadorLocal> resposta = coordLocalRepository.findById(id);
		return resposta.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CoordenadorLocal.class.getName()));
	}

	public CoordenadorLocal insert(CoordenadorLocal obj) {
		obj.setId(null);
		return coordLocalRepository.save(obj);
	}

	public CoordenadorLocal update(CoordenadorLocal obj) {
		CoordenadorLocal newObj = find(obj.getId());
		updateData(newObj, obj);
		return coordLocalRepository.save(obj);
	}

	private void updateData(CoordenadorLocal newObj, CoordenadorLocal obj) {
		newObj.setNome(obj.getNome());
		newObj.setTelefone(obj.getTelefone());
	}

	public CoordenadorLocal fromDTO(CoordenadorLocalDTO objDto) {
		CoordenadorRegional coordRegional = coordRegionalService.find(objDto.getCoordenadorRegional());
		return new CoordenadorLocal(objDto.getId(), objDto.getNome(), objDto.getTelefone(), coordRegional);
	}

}
