package com.acm.tallerfinal.repository;

import com.acm.tallerfinal.entity.Almacen;
import com.acm.tallerfinal.entity.AlmacenProducto;
import com.acm.tallerfinal.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AlmacenProductoRepository extends JpaRepository<AlmacenProducto, Integer> {
    Optional<AlmacenProducto> findByAlmacenAndProducto(Almacen almacen, Producto producto);
}