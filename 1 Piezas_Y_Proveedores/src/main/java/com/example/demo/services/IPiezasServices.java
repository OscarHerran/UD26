package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Piezas;

public interface IPiezasServices {

	//MÉTODOS A IMPLEMENTAR EN EL SERVICES
	public List <Piezas> totalPiezas(); 
	public Piezas guardaPiezas(Piezas pieza);
	public Piezas actualizaPiezas(Piezas pieza);
	public Piezas actualizaConID(int id);
	public void EliminaPieza(int id);
}
