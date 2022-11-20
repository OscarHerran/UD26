package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Piezas;
import com.example.demo.services.PiezasServices;



//HACEMOS USO DEL DECORADOS RESCONTROLLER PARA IMPLEMENTAR EL MAPPEO
@RestController
@RequestMapping("/api")
public class PiezasController {
	
	

	//PARA HACER USO DE LOS MÉTODOS IMPLEMENTAMOS UNA INSTANCIA DEL TIPO SERVICE SEGÚN LA CLASE
	@Autowired
	PiezasServices piezasSERVICES;
	
	//registro total de piezas
	@GetMapping("/piezas")
	public List<Piezas> totalPiezas(){
		return piezasSERVICES.totalPiezas();
	}
	
	//GUARDA UNA INSTANCIA DE PIEZAS 
	@PostMapping("/pieza/add")
	public Piezas guardaPiezas(@RequestBody Piezas pieza) { //ES IMPERATIVO HACER EL REQUESTBODY PUES CASO CONTRARIO DA ERROR
		return piezasSERVICES.guardaPiezas(pieza);
	}
	
	//PREGUNTAR!!!!
	
	//retornamos una entidad según parámetro
	@GetMapping("/piezas/{id}")
	public Piezas PiezasbyID(@PathVariable(name = "id") int id) {
		Piezas piezaID = new Piezas(); //DECLARAMOS UNA INSTANCIA DE LA CLASE
		piezaID = piezasSERVICES.actualizaConID(id); // ADHERIMOS EL VALOR DEL MÉTODO DE SERVICES A LA INSTANCIA CREADA
		return piezaID;
	}
	
	//MÉTODO QUE ACTUALIZA A TODA LA INSTANCIA UBICANDO POR ID
	@PutMapping("/piezas/{id}/actualiza")
	public Piezas actualizaPiezas(@PathVariable(name = "id") int id, @RequestBody Piezas pieza) { // PARA ACTUALIZACION DEL TOTAL DE PARÁMETROS ES IMPERATIVO INDICAR EL ID A APUNTAR, ADEMÁS DE REALIZAR EL @REQUESTBODY CON EL OBJETO E INSTANCIA
		Piezas piezaSel = new Piezas(); //PARA LA ACTUALIZACION SE HA DE INSTANCIAR 2 OBJETOS, UNO QUE RECIBIRÁ LOS DATOS DEL SELECCIONADO Y OTRO QUE SERÁ EL QUE APUNTE A LA ACTUALIZACIÓN
		Piezas piezaActualizada = new Piezas();
		
		piezaSel = piezasSERVICES.actualizaConID(id); //EL SELECCIONADO RECIBE LA RESPUESTA DEL MÉTODO CON PARÁMETRO id para ubicar la instancia específica
		piezaSel.setNombre(pieza.getNombre());
		
		piezaActualizada = piezasSERVICES.actualizaPiezas(piezaSel);//LA INSTANCIA A ACTUALIZAR RECIBE COMO VALOR LA INSTANCIA DECLARADA COMO SERVICES Y QUE ACTUALIZA LLAMANDO DE FORMA RECURSIVA AL MÉTODO ACTUALIZAR Y QUE LA RECIBE COMO PARÁMETRO
		
		return piezaActualizada;
	}
	
	
}
