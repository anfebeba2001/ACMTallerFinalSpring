package com.acm.tallerfinal.repository;

import com.acm.tallerfinal.entity.VentaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaProductoRepository extends JpaRepository<VentaProducto, Integer> {
}