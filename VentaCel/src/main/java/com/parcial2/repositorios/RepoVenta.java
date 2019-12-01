package com.parcial2.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcial2.entidades.Venta;
@Repository
public interface RepoVenta extends JpaRepository<Venta,Integer>{

}
