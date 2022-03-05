package com.model.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.sistem.entities.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

}
