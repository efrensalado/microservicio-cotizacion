package com.efrensalado.cotiza_credito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.efrensalado.cotiza_credito.entity.Cotizacion;
import com.efrensalado.cotiza_credito.entity.Plazo;
import com.efrensalado.cotiza_credito.entity.Producto;
import com.efrensalado.cotiza_credito.models.CotizacionPlazo;
import com.efrensalado.cotiza_credito.service.CotizacionService;
import com.efrensalado.cotiza_credito.service.PlazoService;
import com.efrensalado.cotiza_credito.service.ProductoService;

@RestController
@RequestMapping("/cotizaciones")
public class CotizacionController {
	@Autowired
	private CotizacionService _cotService;
	@Autowired
	private ProductoService _prodService;
	@Autowired
	private PlazoService _plazoService;
	
	@PostMapping()
	public ResponseEntity<CotizacionPlazo> nuevaCotizacion(@RequestBody() Cotizacion cotizacion) {
		Cotizacion nuevoCotizacion = _cotService.save(cotizacion);
		CotizacionPlazo pagosCotizados = new CotizacionPlazo();
		if (cotizacion == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		else {
			Producto prod = new Producto();
			Plazo plazo = new Plazo();
			
			prod = _prodService.getProductoById(nuevoCotizacion.getIdProducto());
			plazo = _plazoService.getPlazoById(nuevoCotizacion.getIdPlazo());
			
			pagosCotizados.setAbonoNormal(_cotService.abonoNormal(prod, plazo));
			pagosCotizados.setAbonoPuntual(_cotService.abonoPuntual(prod, plazo));
			pagosCotizados.setProducto(prod.getNombre());
			pagosCotizados.setSemanas(plazo.getCantidadSemana());
		}
		return ResponseEntity.ok(pagosCotizados);
	}
	
	@GetMapping("/plazos")
	public ResponseEntity<List<Plazo>> getPlazos() {
		List<Plazo> plazos = _plazoService.getAll();
		
		if (plazos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(plazos);
	}
	
	@GetMapping("/producto/{sku}")
	public ResponseEntity<Producto> getProductoBySKU(@RequestParam("sku") int sku) {
		Producto producto = _prodService.getProductoById(sku);
		
		if (producto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(producto);
	}
	
	@GetMapping("/producto/{nombre}")
	public ResponseEntity<List<Producto>> getProductoByNombre(@RequestParam("nombre") String nombre) {
		List<Producto> producto = _prodService.getProductoByNombre(nombre);
		
		if (producto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(producto);
	}
}
