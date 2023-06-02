package com.efrensalado.cotiza_credito.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Id;

@Data()
@Entity
@Table(name="Plazo")
public class Plazo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	private int CantidadSemana;
	private Double TasaNormal;
	private Double TasaPuntual;
	
	
}
