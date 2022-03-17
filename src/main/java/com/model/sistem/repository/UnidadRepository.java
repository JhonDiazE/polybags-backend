package com.model.sistem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.sistem.entities.Unidad;

public interface UnidadRepository  extends JpaRepository<Unidad, Integer>{

	List<Unidad> findByEstadoOrderByDescripcion(String estado);
}
