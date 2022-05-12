package com.allanjhonny.peoplemanager.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer numeroCandidato;
	private Double eficienciaDeAngariacao;
	
	@OneToMany(mappedBy = "candidato")
	private List<CoordenadorRegional> coordenadoresRegionais = new ArrayList<>();
	
	public Candidato() {
		
	}

	public Candidato(Integer id, String nome, Integer numeroCandidato, Double eficienciaDeAngariacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.numeroCandidato = numeroCandidato;
		this.eficienciaDeAngariacao = eficienciaDeAngariacao;
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

	public Integer getNumero() {
		return numeroCandidato;
	}

	public void setNumero(Integer numero) {
		this.numeroCandidato = numero;
	}

	public Double getEficienciaDeAngariacao() {
		return eficienciaDeAngariacao;
	}

	public void setEficienciaDeAngariacao(Double eficienciaDeAngariacao) {
		this.eficienciaDeAngariacao = eficienciaDeAngariacao;
	}
	
	public List<CoordenadorRegional> getCoordenadoresRegionais() {
		return coordenadoresRegionais;
	}

	public void setCoordenadoresRegionais(List<CoordenadorRegional> coordenadoresRegionais) {
		this.coordenadoresRegionais = coordenadoresRegionais;
	}
	
	public Integer getPrevisaoAngariacao() {
		Integer totalPrevisaoAngariacao = 0;
		for(CoordenadorRegional coordRegional:this.coordenadoresRegionais) {
			totalPrevisaoAngariacao = totalPrevisaoAngariacao + coordRegional.getPrevisaoAngariacao();
		}
		
		return totalPrevisaoAngariacao;
	}
	
	public Double getPrevisaoAngariacaoAjustada() {
						
		return this.getPrevisaoAngariacao() * this.eficienciaDeAngariacao;
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
		Candidato other = (Candidato) obj;
		return Objects.equals(id, other.id);
	}
	
}
