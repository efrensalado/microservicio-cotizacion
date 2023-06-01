package com.efrensalado.cotiza_credito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efrensalado.cotiza_credito.entity.Plazo;
import com.efrensalado.cotiza_credito.repository.PlazoRepository;

@Service
public class PlazoService {

	@Autowired
	private PlazoRepository plazoRepository;
	
	public List<Plazo> getAll() {
		return plazoRepository.findAll();
	}
	
	public Plazo getProductoById (int Id) {
		return plazoRepository.findById(Id).orElse(null);
	}
	
	public Plazo save (Plazo plazo) {
		Plazo nuevoPlazo = plazo;
		return plazoRepository.save(nuevoPlazo);
	}
	
	public Plazo edit (Plazo plazo) {
		Plazo plazoObject = plazoRepository.findById(plazo.getID()).orElse(null);
		
		if (plazoObject != null) {
			plazoObject.setCantidadSemana(plazo.getCantidadSemana());
			plazoObject.setTasaNormal(plazo.getTasaNormal());
			plazoObject.setTasaPuntual(plazo.getTasaPuntual());
			plazoRepository.save(plazoObject);
		}
		
		return plazoObject;
	}
	
	public Plazo delete (int Id) {
		Plazo plazo = plazoRepository.findById(Id).orElse(null);
		
		if (plazo != null) {
			plazoRepository.delete(plazo);
		}
		
		return plazo;
	}
}
