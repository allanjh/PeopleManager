package com.allanjhonny.peoplemanager.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.allanjhonny.peoplemanager.domain.enums.PerfilUsuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String nomeUsuario;
	@NotEmpty(message="Preenchimento obrigatório")
	private String senhaUsuario;
	@NotNull(message="Preenchimento obrigatório")
	private Integer perfilUsuario;
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Integer id, String nomeUsuario, String senhaUsuario, PerfilUsuario perfilUsuario) {
		super();
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.senhaUsuario = senhaUsuario;
		this.perfilUsuario = (perfilUsuario==null) ? null : perfilUsuario.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public Integer getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(Integer perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
	
	
}

