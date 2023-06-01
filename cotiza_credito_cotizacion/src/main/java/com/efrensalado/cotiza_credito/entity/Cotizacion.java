package com.efrensalado.cotiza_credito.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;
import javax.persistence.Id;

@Data()
@Entity
@Table(name="Cotizacion")
public class Cotizacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdCotizacion;
	private int IdProducto;
	private int IdPlazo;
}
