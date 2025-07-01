package ACM.TallerFinal.repository;

import ACM.TallerFinal.entity.VentaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaProductoRepository extends JpaRepository<VentaProducto, Integer> {
}