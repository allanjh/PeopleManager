package com.allanjhonny.peoplemanager.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allanjhonny.peoplemanager.domain.Cidade;
import com.allanjhonny.peoplemanager.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResources {
	
	@Autowired
	private CidadeService servico;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cidade> find(@PathVariable Integer id) {
		Cidade cidade = servico.find(id);
		return ResponseEntity.ok().body(cidade);
	}

}
