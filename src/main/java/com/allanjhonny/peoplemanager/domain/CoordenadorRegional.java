package com.allanjhonny.peoplemanager.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CoordenadorRegional implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	
	@OneToMany(mappedBy = "coordenadorRegional")
	private List<CoordenadorLocal> coordenadoresLocais = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="candidato_id")
	private Candidato candidato;
	
	public CoordenadorRegional() {
		
	}

	public CoordenadorRegional(Integer id, String nome, String telefone, Candidato candidato) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.candidato = candidato;
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

	public List<CoordenadorLocal> getCoordenadoresLocais() {
		return coordenadoresLocais;
	}

	public void setCoordenadoresLocais(List<CoordenadorLocal> coordenadoresLocais) {
		this.coordenadoresLocais = coordenadoresLocais;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	public Integer getPrevisaoAngariacao() {
		
		Integer previsaoAngariacao = 0;
		for(CoordenadorLocal coordLocal: this.coordenadoresLocais) {
			previsaoAngariacao = previsaoAngariacao + coordLocal.getPrevisaoAngariacao();
		}
		
		return previsaoAngariacao;
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
		CoordenadorRegional other = (CoordenadorRegional) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
