package com.allanjhonny.peoplemanager.domain.enums;

public enum PerfilUsuario {

	MEMBRO(1, "ROLE_MEMBRO"), COORDENADOR(2, "ROLE_ADMIN");

	private int cod;
	private String descrição;

	private PerfilUsuario(int cod, String descrição) {
		this.cod = cod;
		this.descrição = descrição;
	}

	public int getCod() {
		return cod;
	}

	public String getDescrição() {
		return descrição;
	}

	public static PerfilUsuario toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (PerfilUsuario x : PerfilUsuario.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id Inválido: " + cod);
	}

}
