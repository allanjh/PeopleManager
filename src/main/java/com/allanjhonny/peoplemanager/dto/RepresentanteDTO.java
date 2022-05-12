package com.allanjhonny.peoplemanager.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.allanjhonny.peoplemanager.domain.Representante;

public class RepresentanteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String telefone;
	
	@NotNull(message = "Preenchimento obrigatório")
	private Integer cidade;

	@NotNull(message = "Preenchimento obrigatório")
	private Integer coordenadorLocal;
	
	@NotNull(message = "Preenchimento obrigatório")
	private Integer previsaoAngariacao;
	
	public RepresentanteDTO() {

	}

	public RepresentanteDTO(Representante representante) {
		super();
		this.id = representante.getId();
		this.nome = representante.getNome();
		this.telefone = representante.getTelefone();
		this.cidade = representante.getCidade().getId();
		this.coordenadorLocal = representante.getCoordenadorLocal().getId();
		this.previsaoAngariacao = representante.getPrevisaoAngariacao();
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

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	public Integer getCoordenadorLocal() {
		return coordenadorLocal;
	}

	public void setCoordenadorLocal(Integer coordenadorLocal) {
		this.coordenadorLocal = coordenadorLocal;
	}

	public Integer getPrevisaoAngariacao() {
		return previsaoAngariacao;
	}

	public void setPrevisaoAngariacao(Integer previsaoAngariacao) {
		this.previsaoAngariacao = previsaoAngariacao;
	}
	
	

}
