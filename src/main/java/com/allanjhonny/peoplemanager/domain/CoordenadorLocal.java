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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CoordenadorLocal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="coordenadorRegional_id")
	private CoordenadorRegional coordenadorRegional;
	
	@OneToMany(mappedBy="coordenadorLocal", cascade=CascadeType.ALL)
	private List<Representante> representantes = new ArrayList<>();

	public CoordenadorLocal() {
		
	}

	public CoordenadorLocal(Integer id, String nome, String telefone, CoordenadorRegional coordenadorRegional) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.coordenadorRegional = coordenadorRegional;
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

	public CoordenadorRegional getCoordenadorRegional() {
		return coordenadorRegional;
	}

	public void setCoordenadorRegional(CoordenadorRegional coordenadorRegional) {
		this.coordenadorRegional = coordenadorRegional;
	}
	
	public List<Representante> getRepresentantes() {
		return representantes;
	}

	public void setRepresentante(List<Representante> representantes) {
		this.representantes = representantes;
	}
	
	public Integer getPrevisaoAngariacao() {
		
		Integer previsaoAngariacao = 0;
		for (Representante representante:this.representantes) {
			previsaoAngariacao = previsaoAngariacao + representante.getPrevisaoAngariacao();
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
		CoordenadorLocal other = (CoordenadorLocal) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
