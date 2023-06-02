package com.efrensalado.cotiza_credito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.efrensalado.cotiza_credito.entity.Plazo;
import com.efrensalado.cotiza_credito.service.PlazoService;

@RestController
@RequestMapping("/plazos")
public class PlazoController {
	@Autowired
	private PlazoService _plazoService;
	
	@PostMapping()
	public ResponseEntity<Plazo> nuevoPlazo(@RequestBody() Plazo plazo) {
		Plazo nuevoPlazo = _plazoService.save(plazo);
		
		if (plazo == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.ok(nuevoPlazo);
	}
}
