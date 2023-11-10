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
@RequestMapping("/api")
public class AlmacenController {
	
	@Autowired
	AlmacenServiceImpl almacenServiceImpl;
	
	@GetMapping("/almacenes")
	public List<Almacen> listarAlmacen(){
		return almacenServiceImpl.listarAlmacenes();
	}
	
	@PostMapping("/almacenes")
	public Almacen salvarArticulo(@RequestBody Almacen almacen) {
		
		return almacenServiceImpl.guardarAlmacen(almacen);
	}
	
	@GetMapping("/almacenes/{codigo}")
	public Almacen departamentoXID(@PathVariable(name="codigo") Integer codigo) {
		
		Almacen almacen_xid= new Almacen();
		
		almacen_xid=almacenServiceImpl.almacenXID(codigo);
		
		System.out.println("articulo XID: "+almacen_xid);
		
		return almacen_xid;
	}
	
	@PutMapping("/almacenes/{codigo}")
	public Almacen actualizarArticulo(@PathVariable(name="codigo")Integer codigo,@RequestBody Almacen almacen) {
		
		Almacen almacen_seleccionado= new Almacen();
		Almacen almacen_actualizado= new Almacen();
		
		almacen_seleccionado= almacenServiceImpl.almacenXID(codigo);
		
		almacen_seleccionado.setLugar(almacen.getLugar());
		almacen_seleccionado.setCapacidad(almacen.getCapacidad());
		
		almacen_seleccionado = almacenServiceImpl.actualizarAlmacen(almacen_seleccionado);
		
		System.out.println("El almacen actualizado es: "+ almacen_actualizado);
		
		return almacen_actualizado;
	}
	
	@DeleteMapping("/almacenes/{codigo}")
	public void eliminarDepartamento(@PathVariable(name="codigo")Integer codigo) {
		almacenServiceImpl.eliminarAlmacen(codigo);
	}
}
