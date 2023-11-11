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

import com.example.demo.dto.Almacen;
import com.example.demo.service.AlmacenServiceImpl;

@RestController
@RequestMapping("/almacenes")
public class AlmacenController {
	
	@Autowired
	AlmacenServiceImpl almacenServiceImpl;
	
	@GetMapping("/all")
	public List<Almacen> listarAlmacen(){
		return almacenServiceImpl.listarAlmacenes();
	}
	
	@PostMapping("/add")
	public Almacen salvarAlmacen(@RequestBody Almacen almacen) {
		
		return almacenServiceImpl.guardarAlmacen(almacen);
	}
	
	@GetMapping("/{id}")
	public Almacen almacenXID(@PathVariable(name="id") Integer id) {
		
		Almacen almacen_xid= new Almacen();
		
		almacen_xid=almacenServiceImpl.almacenXID(id);
				
		return almacen_xid;
	}
	
	@PutMapping("/{id}")
	public Almacen actualizarAlmacen(@PathVariable(name="id")Integer id,@RequestBody Almacen almacen) {
		
		Almacen almacen_seleccionado= new Almacen();
		Almacen almacen_actualizado= new Almacen();
		
		almacen_seleccionado= almacenServiceImpl.almacenXID(id);
		
		almacen_seleccionado.setLugar(almacen.getLugar());
		almacen_seleccionado.setCapacidad(almacen.getCapacidad());
		
		almacen_actualizado = almacenServiceImpl.actualizarAlmacen(almacen_seleccionado);
		
		System.out.println("El almacen actualizado es: "+ almacen_actualizado);
		
		return almacen_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarAlmacen(@PathVariable(name="id")Integer id) {
		almacenServiceImpl.eliminarAlmacen(id);
	}
}
