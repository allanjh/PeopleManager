package com.allanjhonny.peoplemanager.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.allanjhonny.peoplemanager.domain.Candidato;

public class CandidatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;
	private Integer numeroCandidato;
	private Double eficienciaDeAngariacao;

	public CandidatoDTO() {

	}

	public CandidatoDTO(Candidato candidato) {
		this.id = candidato.getId();
		this.nome = candidato.getNome();
		this.numeroCandidato = candidato.getNumero();
		this.eficienciaDeAngariacao = candidato.getEficienciaDeAngariacao();
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

	public Integer getNumeroCandidato() {
		return numeroCandidato;
	}

	public void setNumeroCandidato(Integer numeroCandidato) {
		this.numeroCandidato = numeroCandidato;
	}

	public Double getEficienciaDeAngariacao() {
		return eficienciaDeAngariacao;
	}

	public void setEficienciaDeAngariacao(Double eficienciaDeAngariacao) {
		this.eficienciaDeAngariacao = eficienciaDeAngariacao;
	}
	
	

}
