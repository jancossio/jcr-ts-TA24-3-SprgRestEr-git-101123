package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Almacen;

public interface IAlmacenDAO extends JpaRepository<Almacen, Integer>{

}
