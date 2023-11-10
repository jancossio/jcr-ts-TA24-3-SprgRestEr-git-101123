package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Caja;

public interface ICajaService {

	public List<Caja>listarCajas();
	
	public Caja guardarCaja(Caja caja);
	
	public Caja cajaXID(String num_Referencia);
	
	public Caja actualizarCaja(Caja caja);

	public void eliminarCaja(String num_Referencia);
}
