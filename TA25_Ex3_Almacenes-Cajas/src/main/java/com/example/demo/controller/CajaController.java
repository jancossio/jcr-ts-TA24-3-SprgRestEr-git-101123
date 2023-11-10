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
@RequestMapping("/api")
public class CajaController {

	@Autowired
	CajaServiceImpl cajaServiceImpl;
	
	@GetMapping("/cajas")
	public List<Caja> listarAlmacen(){
		return cajaServiceImpl.listarCajas();
	}
	
	@PostMapping("/cajas")
	public Caja salvarArticulo(@RequestBody Caja caja) {
		
		return cajaServiceImpl.guardarCaja(caja);
	}
	
	@GetMapping("/cajas/{codigo}")
	public Caja departamentoXID(@PathVariable(name="num_Referencia") String num_Referencia) {
		
		Caja almacen_xid= new Caja();
		
		almacen_xid=cajaServiceImpl.cajaXID(num_Referencia);
		
		System.out.println("Caja XID: "+almacen_xid);
		
		return almacen_xid;
	}
	
	@PutMapping("/cajas/{num_Referencia}")
	public Caja actualizarArticulo(@PathVariable(name="num_Referencia")String num_Referencia,@RequestBody Caja caja) {
		
		Caja caja_seleccionada= new Caja();
		Caja caja_actualizada= new Caja();
		
		caja_seleccionada= cajaServiceImpl.cajaXID(num_Referencia);
		
		caja_seleccionada.setContenido(caja.getContenido());
		caja_seleccionada.setValor(caja.getValor());
		caja_seleccionada.setAlmacen(caja.getAlmacen());

		
		caja_seleccionada = cajaServiceImpl.actualizarCaja(caja_seleccionada);
		
		System.out.println("El almacen actualizado es: "+ caja_actualizada);
		
		return caja_actualizada;
	}
	
	@DeleteMapping("/cajas/{num_Referencia}")
	public void eliminarDepartamento(@PathVariable(name="num_Referencia") String num_Referencia) {
		cajaServiceImpl.eliminarCaja(num_Referencia);
	}
}
