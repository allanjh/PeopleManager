package com.allanjhonny.peoplemanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allanjhonny.peoplemanager.domain.Cidade;
import com.allanjhonny.peoplemanager.domain.CoordenadorLocal;
import com.allanjhonny.peoplemanager.domain.Representante;
import com.allanjhonny.peoplemanager.dto.RepresentanteDTO;
import com.allanjhonny.peoplemanager.repositories.RepresentanteRepository;
import com.allanjhonny.peoplemanager.services.exceptions.ObjectNotFoundException;

@Service
public class RepresentanteService {
	
	@Autowired
	private RepresentanteRepository representanteRepository;
	
	@Autowired
	private CoordLocalService coordenadorLocalService;
	
	@Autowired
	private CidadeService cidadeService;
	
	public Representante find(Integer id) {
		Optional<Representante> resposta = representanteRepository.findById(id);
		return resposta.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Representante.class.getName()));
	}
	
	public Representante insert(Representante obj) {
		obj.setId(null);
		return representanteRepository.save(obj);
	}

	public Representante update(Representante obj) {
		Representante newObj = find(obj.getId());
		updateData(newObj, obj);
		return representanteRepository.save(obj);
	}

	private void updateData(Representante newObj, Representante obj) {
		newObj.setNome(obj.getNome());
		newObj.setTelefone(obj.getTelefone());
	}

	public Representante fromDTO(RepresentanteDTO objDto) {
		CoordenadorLocal coordLocal = coordenadorLocalService.find(objDto.getCoordenadorLocal());
		Cidade cidade = cidadeService.find(objDto.getCidade());
		return new Representante(objDto.getId(), objDto.getNome(), objDto.getTelefone(), objDto.getPrevisaoAngariacao(), cidade, coordLocal);
	}

}
