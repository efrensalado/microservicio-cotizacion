package com.efrensalado.cotiza_credito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efrensalado.cotiza_credito.entity.Producto;
import com.efrensalado.cotiza_credito.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productRepository;
	
	public List<Producto> getAll() {
		return productRepository.findAll();
	}
	
	public Producto getProductoById (int Id) {
		return productRepository.findById(Id).orElse(null);
	}
	
	public Producto save (Producto producto) {
		Producto product = producto;
		return productRepository.save(product);
	}
	
	public Producto edit (Producto producto) {
		Producto product = productRepository.findById(producto.getSKU()).orElse(null);
		
		if (product != null) {
			product.setNombre(producto.getNombre());
			product.setDescripcion(producto.getDescripcion());
			product.setPrecio(producto.getPrecio());
			productRepository.save(product);
		}
		
		return product;
	}
	
	public Producto delete (int Id) {
		Producto product = productRepository.findById(Id).orElse(null);
		
		if (product != null) {
			productRepository.delete(product);
		}
		
		return product;
	}
}
