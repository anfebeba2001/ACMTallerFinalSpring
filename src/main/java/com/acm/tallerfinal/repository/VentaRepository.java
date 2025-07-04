package com.acm.tallerfinal.repository;

import com.acm.tallerfinal.entity.Usuario;
import com.acm.tallerfinal.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    List<Venta> findByCliente(Usuario cliente);
    List<Venta> findByFechaVentaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}