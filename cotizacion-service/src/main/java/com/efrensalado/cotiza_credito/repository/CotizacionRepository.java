package com.efrensalado.cotiza_credito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efrensalado.cotiza_credito.entity.Cotizacion;

public interface CotizacionRepository extends JpaRepository<Cotizacion, Integer> {

}
