package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Proveedores;

public interface IProveedoresServices {

	public Proveedores guardasProveedores(Proveedores prov); 	 	//Create
	public List <Proveedores> totalProveedores();					//REGISTER
	public Proveedores actualizaProveedores(Proveedores prov);		//UPDATE
	public void eliminaProveedores(int id);							//DELETE
	public Proveedores ubicaConID(int id);
}
