package com.model.sistem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.sistem.entities.Empresa;
import com.model.sistem.entities.Especialidad;
import com.model.sistem.entities.ParametroEstadoGeneral;

public interface ParametroEstadoGeneralRepository  extends JpaRepository<ParametroEstadoGeneral, Integer>{

	List<ParametroEstadoGeneral> findByEstadoAndTablaParametro(String estado, String tablaParametro);

}
