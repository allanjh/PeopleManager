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

import com.allanjhonny.peoplemanager.domain.CoordenadorLocal;
import com.allanjhonny.peoplemanager.dto.CoordenadorLocalDTO;
import com.allanjhonny.peoplemanager.services.CoordLocalService;

@RestController
@RequestMapping(value = "/coordenadoresLocais")
public class CoordLocalResources {
	
	@Autowired
	private CoordLocalService servico;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<CoordenadorLocal> find(@PathVariable Integer id) {
		CoordenadorLocal coordLocal = servico.find(id);
		return ResponseEntity.ok().body(coordLocal);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CoordenadorLocalDTO objDto){
		CoordenadorLocal obj = servico.fromDTO(objDto);
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CoordenadorLocalDTO objDto, @PathVariable Integer id){
		CoordenadorLocal obj = servico.fromDTO(objDto);
		obj.setId(id);
		obj = servico.update(obj);
		return ResponseEntity.noContent().build();
	}

}
