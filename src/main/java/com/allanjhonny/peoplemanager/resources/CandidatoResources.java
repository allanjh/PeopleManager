package com.allanjhonny.peoplemanager.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.allanjhonny.peoplemanager.domain.Candidato;
import com.allanjhonny.peoplemanager.dto.CandidatoDTO;
import com.allanjhonny.peoplemanager.services.CandidatoService;

@RestController
@RequestMapping(value = "/candidatos")
public class CandidatoResources {
	
	@Autowired
	private CandidatoService servico;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Candidato> find(@PathVariable Integer id) {
		Candidato candidato = servico.find(id);
		return ResponseEntity.ok().body(candidato);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CandidatoDTO objDto){
		Candidato obj = servico.fromDTO(objDto);
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CandidatoDTO objDto, @PathVariable Integer id){
		Candidato obj = servico.fromDTO(objDto);
		obj.setId(id);
		obj = servico.update(obj);
		return ResponseEntity.noContent().build();
	}

}
