package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProveedoresDAO;
import com.example.demo.dto.Proveedores;

@Service
public class ProveedoresServices implements IProveedoresServices{
	
	@Autowired
	IProveedoresDAO proveedoresDAO;

	@Override
	public List<Proveedores> totalProveedores() {
		return proveedoresDAO.findAll();
	}

	@Override
	public Proveedores guardasProveedores(Proveedores prov) {
		
		return proveedoresDAO.save(prov);
	}

	@Override
	public Proveedores actualizaProveedores(Proveedores prov) {
		
		return proveedoresDAO.save(prov);
	}

	@Override
	public void eliminaProveedores(int id) {
		
		proveedoresDAO.deleteById(id);
	}

	@Override
	public Proveedores ubicaConID(int id) {
		
		return proveedoresDAO.findById(id).get();
	}

}
