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

import com.allanjhonny.peoplemanager.domain.Representante;
import com.allanjhonny.peoplemanager.dto.RepresentanteDTO;
import com.allanjhonny.peoplemanager.services.RepresentanteService;

@RestController
@RequestMapping(value = "/representantes")
public class RepresentanteResources {
	
	@Autowired
	private RepresentanteService servico;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Representante> find(@PathVariable Integer id) {
		Representante representante = servico.find(id);
		return ResponseEntity.ok().body(representante);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody RepresentanteDTO objDto){
		Representante obj = servico.fromDTO(objDto);
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody RepresentanteDTO objDto, @PathVariable Integer id){
		Representante obj = servico.fromDTO(objDto);
		obj.setId(id);
		obj = servico.update(obj);
		return ResponseEntity.noContent().build();
	}

}
