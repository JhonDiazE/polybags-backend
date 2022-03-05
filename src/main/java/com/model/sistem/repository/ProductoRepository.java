package com.model.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.sistem.entities.Producto;

public interface ProductoRepository  extends JpaRepository<Producto, String>{

}
