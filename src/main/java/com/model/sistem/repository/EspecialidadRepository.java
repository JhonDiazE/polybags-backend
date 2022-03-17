package com.model.sistem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.sistem.entities.Empresa;
import com.model.sistem.entities.Especialidad;

public interface EspecialidadRepository  extends JpaRepository<Especialidad, Integer>{

	List<Especialidad> findByEstadoAndEstadoCamposPtAndEmpresa(String estado, String estadoCamposPt, Empresa empresa);
}
