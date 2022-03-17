package com.model.sistem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.sistem.entities.Categoria;
import com.model.sistem.entities.Linea;

public interface CategoriaRepository  extends JpaRepository<Categoria, Integer>{

	List<Categoria> findByEstadoAndLinea(String estado, Linea linea);
}
