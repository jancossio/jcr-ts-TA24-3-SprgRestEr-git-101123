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

import com.example.demo.dto.Caja;
import com.example.demo.service.CajaServiceImpl;

@RestController
@RequestMapping("/cajas")
public class CajaController {

	@Autowired
	CajaServiceImpl cajaServiceImpl;
	
	@GetMapping("/all")
	public List<Caja> listarCaja(){
		return cajaServiceImpl.listarCajas();
	}
	
	@PostMapping("/add")
	public Caja salvarCaja(@RequestBody Caja caja) {
		
		return cajaServiceImpl.guardarCaja(caja);
	}
	
	@GetMapping("/{id}")
	public Caja cajaXID(@PathVariable(name="id") String id) {
		
		Caja almacen_xid= new Caja();
		
		almacen_xid=cajaServiceImpl.cajaXID(id);
		
		//System.out.println("Caja XID: "+almacen_xid);
		
		return almacen_xid;
	}
	
	@PutMapping("/{id}")
	public Caja actualizarCaja(@PathVariable(name="id")String id,@RequestBody Caja caja) {
		
		Caja caja_seleccionada= new Caja();
		Caja caja_actualizada= new Caja();
		
		caja_seleccionada= cajaServiceImpl.cajaXID(id);
		
		caja_seleccionada.setContenido(caja.getContenido());
		caja_seleccionada.setValor(caja.getValor());
		caja_seleccionada.setAlmacen(caja.getAlmacen());

		
		caja_actualizada = cajaServiceImpl.actualizarCaja(caja_seleccionada);
		
		//System.out.println("El almacen actualizado es: "+ caja_actualizada);
		
		return caja_actualizada;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarCaja(@PathVariable(name="id") String id) {
		cajaServiceImpl.eliminarCaja(id);
	}
}
