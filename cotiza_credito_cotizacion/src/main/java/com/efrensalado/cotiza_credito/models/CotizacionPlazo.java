package com.efrensalado.cotiza_credito.models;

public class CotizacionPlazo {
	private String Producto;
	private Double AbonoNormal;
	private Double AbonoPuntual;
	private int Semanas;

	public Double getAbonoNormal() {
		return AbonoNormal;
	}

	public void setAbonoNormal(Double abonoNormal) {
		AbonoNormal = abonoNormal;
	}

	public Double getAbonoPuntual() {
		return AbonoPuntual;
	}

	public void setAbonoPuntual(Double abonoPuntual) {
		AbonoPuntual = abonoPuntual;
	}

	public String getProducto() {
		return Producto;
	}

	public void setProducto(String producto) {
		Producto = producto;
	}

	public int getSemanas() {
		return Semanas;
	}

	public void setSemanas(int semanas) {
		Semanas = semanas;
	}

}
