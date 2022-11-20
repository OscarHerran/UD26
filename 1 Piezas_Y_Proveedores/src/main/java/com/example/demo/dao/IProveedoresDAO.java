package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Proveedores;

public interface IProveedoresDAO extends JpaRepository<Proveedores, Integer> {
	
	//public Proveedores filtraPorID(int id);
}
