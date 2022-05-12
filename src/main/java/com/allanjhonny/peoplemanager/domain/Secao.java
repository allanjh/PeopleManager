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
public class Secao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer codigoSecao;
	private String local;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="zona_id")
	private Zona zona;
	
	public Secao() {
		
	}

	public Secao(Integer id, Integer codigoSecao, String local, Zona zona) {
		super();
		this.id = id;
		this.codigoSecao = codigoSecao;
		this.local = local;
		this.zona = zona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigoSecao() {
		return codigoSecao;
	}

	public void setCodigoSecao(Integer codigoSecao) {
		this.codigoSecao = codigoSecao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
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
		Secao other = (Secao) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
