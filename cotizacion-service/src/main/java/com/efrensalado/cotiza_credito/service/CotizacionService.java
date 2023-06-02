package com.efrensalado.cotiza_credito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efrensalado.cotiza_credito.entity.Cotizacion;
import com.efrensalado.cotiza_credito.entity.Plazo;
import com.efrensalado.cotiza_credito.entity.Producto;
import com.efrensalado.cotiza_credito.repository.CotizacionRepository;

@Service
public class CotizacionService {

	@Autowired
	private CotizacionRepository cotizacionRepository;
	
	public List<Cotizacion> getAll() {
		return cotizacionRepository.findAll();
	}
	
	public Cotizacion save (Cotizacion cotizacion) {
		Cotizacion nueva = cotizacion;
		return cotizacionRepository.save(nueva);
	}
	
	public Double abonoNormal (Producto prod, Plazo plazo) {
		return ((prod.getPrecio() * plazo.getTasaNormal()) + prod.getPrecio() ) / plazo.getCantidadSemana();
	}
	
	public Double abonoPuntual (Producto prod, Plazo plazo) {
		return ((prod.getPrecio() * plazo.getTasaPuntual()) + prod.getPrecio() ) / plazo.getCantidadSemana();
	}
}
