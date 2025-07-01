package ACM.TallerFinal.repository;

import ACM.TallerFinal.entity.Usuario;
import ACM.TallerFinal.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    List<Venta> findByCliente(Usuario cliente);
    List<Venta> findByFechaVentaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}