package com.model.sistem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.sistem.entities.Empresa;
import com.model.sistem.entities.Especialidad;
import com.model.sistem.entities.Linea;

public interface LineaRepository  extends JpaRepository<Linea, Integer>{

	List<Linea> findByEstadoAndEspecialidadAndEmpresa(String estado, Especialidad especialidad, Empresa empresa);

}
