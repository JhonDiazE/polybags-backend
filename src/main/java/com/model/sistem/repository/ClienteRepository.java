package com.model.sistem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.sistem.entities.Cliente;
import com.model.sistem.enums.EstadoEnum;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

	List<Cliente> findByEstadoOrderByRazonSocial(String estado);
}
