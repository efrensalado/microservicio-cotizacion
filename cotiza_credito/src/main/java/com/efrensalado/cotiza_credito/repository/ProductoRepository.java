package com.efrensalado.cotiza_credito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efrensalado.cotiza_credito.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
