package com.allanjhonny.peoplemanager.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.allanjhonny.peoplemanager.domain.CoordenadorRegional;

public class CoordenadorRegionalDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String telefone;
	
	@NotNull(message = "Preenchimento obrigatório")
	private Integer candidato;
	
	public CoordenadorRegionalDTO() {
		
	}

	public CoordenadorRegionalDTO(CoordenadorRegional coordRegional) {
		super();
		this.id = coordRegional.getId();
		this.nome = coordRegional.getNome();
		this.telefone = coordRegional.getTelefone();
		this.candidato = coordRegional.getCandidato().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getCandidato() {
		return candidato;
	}

	public void setCandidato(Integer candidato) {
		this.candidato = candidato;
	}
	
	
	
	

}
