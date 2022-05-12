package com.allanjhonny.peoplemanager.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.allanjhonny.peoplemanager.domain.enums.PerfilUsuario;

@Entity
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String nomeMenu;
	String urlMenu;
	Integer perfilUsuario;

	public Menu() {

	}

	public Menu(Integer id, String nomeMenu, String urlMenu, PerfilUsuario perfilUsuario) {
		super();
		this.id = id;
		this.nomeMenu = nomeMenu;
		this.urlMenu = urlMenu;
		this.perfilUsuario = (perfilUsuario == null) ? null : perfilUsuario.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeMenu() {
		return nomeMenu;
	}

	public void setNomeMenu(String nomeMenu) {
		this.nomeMenu = nomeMenu;
	}

	public String getUrlMenu() {
		return urlMenu;
	}

	public void setUrlMenu(String urlMenu) {
		this.urlMenu = urlMenu;
	}

	public PerfilUsuario getPerfilUsuario() {
		return PerfilUsuario.toEnum(perfilUsuario);
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario.getCod();
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
		Menu other = (Menu) obj;
		return Objects.equals(id, other.id);
	}

}
