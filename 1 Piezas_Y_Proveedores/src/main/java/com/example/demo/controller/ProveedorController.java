package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Proveedores;
import com.example.demo.services.ProveedoresServices;

@RestController
@RequestMapping("/api")
public class ProveedorController {
	
	@Autowired
	ProveedoresServices provSERVICES;
	
	@GetMapping("/proveedores")
	public List<Proveedores> totalProveedores(){
		return provSERVICES.totalProveedores();
	}
	
	@PostMapping("/proveedores/add")
	public Proveedores guardaProveedor(@RequestBody Proveedores prov) {
		return provSERVICES.guardasProveedores(prov);
	}
	
	@GetMapping("/proveedores/{id}")
	public Proveedores ubicaPorID(@PathVariable (name = "id") int id) {
		Proveedores provi = new Proveedores();
		provi = provSERVICES.ubicaConID(id);
		
		return provi;
	}
	
	@PutMapping("/proveeedores/{id}/actualiza")
	public Proveedores actualizaProveedores(@PathVariable (name = "id") int id, @RequestBody Proveedores prov) {
		Proveedores provSEL = new Proveedores();
		Proveedores provACTUALIZA = new Proveedores();
		provSEL = provSERVICES.ubicaConID(id);
		provSEL.setNombre(prov.getNombre());
		provSEL.setSuministra(prov.getSuministra());
		provACTUALIZA = provSEL;
		
		return provACTUALIZA;
	}
	
	@DeleteMapping("proveedores/{id}/elimina")
	public void eliminaProveedores(@PathVariable (name = "id") int id) {
		provSERVICES.eliminaProveedores(id);
	}
}
