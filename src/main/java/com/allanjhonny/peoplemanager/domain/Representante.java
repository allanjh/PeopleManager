package com.allanjhonny.peoplemanager.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Representante implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	private Integer previsaoAngariacao;
	
	@ManyToOne
	@JoinColumn(name="cidade_id")
	private Cidade cidade;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="coordenadorLocal_id")
	private CoordenadorLocal coordenadorLocal;
	
	public Representante() {
		
	}

	public Representante(Integer id, String nome, String telefone, Integer previsaoAngariacao, Cidade cidade,
			CoordenadorLocal coordenadorLocal) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.previsaoAngariacao = previsaoAngariacao;
		this.cidade = cidade;
		this.coordenadorLocal = coordenadorLocal;
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

	public Integer getPrevisaoAngariacao() {
		return previsaoAngariacao;
	}

	public void setPrevisaoAngariacao(Integer previsaoAngariacao) {
		this.previsaoAngariacao = previsaoAngariacao;
	}

	public CoordenadorLocal getCoordenadorLocal() {
		return coordenadorLocal;
	}

	public void setCoordenadorLocal(CoordenadorLocal coordenadorLocal) {
		this.coordenadorLocal = coordenadorLocal;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Representante other = (Representante) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
