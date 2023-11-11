package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="almacen")
public class Almacen {

	@Id
	@Column(name = "codigo")
	private Integer id;
	@Column(name = "lugar")
	private String lugar;
	@Column(name = "capacidad")
	private Integer capacidad;
	
	@OneToMany
    @JoinColumn(name="almacen")
    private List<Caja> caja;

	
	public Almacen() {

	}
	
	public Almacen(Integer id, String lugar, Integer capacidad, List<Caja> caja) {
		super();
		this.id = id;
		this.lugar = lugar;
		this.capacidad = capacidad;
		this.caja = caja;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Caja")
	public List<Caja> getCaja() {
		return caja;
	}

	public void setCaja(List<Caja> caja) {
		this.caja = caja;
	}

	@Override
	public String toString() {
		return "Almacen [id=" + id + ", lugar=" + lugar + ", capacidad=" + capacidad+ "]";
	}
}
