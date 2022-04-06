package com.model.sistem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.sistem.entities.ConfiguracionCotizacion;
import com.model.sistem.entities.DetalleConfiguracionCotizacion;

public interface DetalleConfiguracionCotizacionRepository  extends JpaRepository<DetalleConfiguracionCotizacion, Long>{

	List<DetalleConfiguracionCotizacion> findByConfiguracionCotizacion(ConfiguracionCotizacion configuracionCotizacion);

}
