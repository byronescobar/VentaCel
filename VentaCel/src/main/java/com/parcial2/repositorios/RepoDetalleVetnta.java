package com.parcial2.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcial2.entidades.DetalleVenta;
@Repository
public interface RepoDetalleVetnta extends JpaRepository<DetalleVenta,Integer> {

}
