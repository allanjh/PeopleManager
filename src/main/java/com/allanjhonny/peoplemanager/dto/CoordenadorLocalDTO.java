package com.allanjhonny.peoplemanager.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.allanjhonny.peoplemanager.domain.CoordenadorLocal;

public class CoordenadorLocalDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String telefone;

	@NotNull(message = "Preenchimento obrigatório")
	private Integer coordenadorRegional;

	public CoordenadorLocalDTO() {

	}

	public CoordenadorLocalDTO(CoordenadorLocal coordLocal) {
		super();
		this.id = coordLocal.getId();
		this.nome = coordLocal.getNome();
		this.telefone = coordLocal.getTelefone();
		this.coordenadorRegional = coordLocal.getCoordenadorRegional().getId();
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

	public Integer getCoordenadorRegional() {
		return coordenadorRegional;
	}

	public void setCoordenadorRegional(Integer coordenadorRegional) {
		this.coordenadorRegional = coordenadorRegional;
	}
	
	

}
