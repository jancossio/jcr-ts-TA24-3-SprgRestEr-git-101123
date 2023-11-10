package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Almacen;

public interface IAlmacenService {

	public List<Almacen>listarAlmacenes();
	
	public Almacen guardarAlmacen(Almacen empleado);
	
	public Almacen almacenXID(Integer codigo);
	
	public Almacen actualizarAlmacen(Almacen empleado);

	public void eliminarAlmacen(Integer codigo);
}
