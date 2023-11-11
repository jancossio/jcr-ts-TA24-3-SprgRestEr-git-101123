package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cajas")
public class Caja {

	@Id
	@Column(name = "num_Referencia")
	private String id;
	@Column(name = "contenido")
	private String contenido;
	@Column(name = "valor")
	private Integer valor;
	
	@ManyToOne
    @JoinColumn(name="almacen")
    private Almacen almacen;
	
	
	public Caja(){
		
	}

	public Caja(String id, String contenido, Integer valor, Almacen almacen) {
		super();
		this.id = id;
		this.contenido = contenido;
		this.valor = valor;
		this.almacen = almacen;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	@Override
	public String toString() {
		return "Caja [id=" + id + ", contenido=" + contenido + ", valor=" + valor + ", almacen="
				+ almacen + "]";
	}
}
