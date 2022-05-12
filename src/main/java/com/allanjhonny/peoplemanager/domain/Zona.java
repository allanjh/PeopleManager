package com.allanjhonny.peoplemanager.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Zona implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer codigoZona;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "CIDADE_ZONA",
			joinColumns = @JoinColumn(name = "zona_id"),
			inverseJoinColumns = @JoinColumn(name = "cidade_id")
			)
	private List<Cidade> cidades = new ArrayList<>();

	@OneToMany(mappedBy="zona", cascade=CascadeType.ALL)
	private List<Secao> secoes = new ArrayList<>();

	public Zona() {
		
	}

	public Zona(Integer id, Integer codigoZona) {
		super();
		this.id = id;
		this.codigoZona = codigoZona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigoZona() {
		return codigoZona;
	}

	public void setCodigoZona(Integer codigoZona) {
		this.codigoZona = codigoZona;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	public List<Secao> getSecoes() {
		return secoes;
	}

	public void setSecoes(List<Secao> secoes) {
		this.secoes = secoes;
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
		Zona other = (Zona) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
