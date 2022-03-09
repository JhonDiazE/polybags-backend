package com.model.sistem.enums;

import java.util.Arrays;

public enum EstadoEnum {

	ACTIVO("A"),
	INACTIVO("I");

	EstadoEnum(String estado) {
		this.estado=estado;
	}
	
	private String estado;

	public String getEstado() {
		return estado;
	}

	public static EstadoEnum getEstadoEnum(String estado) {
		return Arrays.stream(EstadoEnum.values())
				.filter(x -> x.getEstado().equals(estado))
				.findFirst()
				.orElse(null);
	}
}
