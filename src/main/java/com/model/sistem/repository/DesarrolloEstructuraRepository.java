package com.model.sistem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.sistem.entities.DesarrolloEstructura;
import com.model.sistem.enums.EstadoEnum;

public interface DesarrolloEstructuraRepository  extends JpaRepository<DesarrolloEstructura, Integer>{

	List<DesarrolloEstructura> findByEstado(String estado);
}
