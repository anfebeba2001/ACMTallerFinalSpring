package ACM.TallerFinal.repository;

import ACM.TallerFinal.entity.Almacen;
import ACM.TallerFinal.entity.AlmacenProducto;
import ACM.TallerFinal.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AlmacenProductoRepository extends JpaRepository<AlmacenProducto, Integer> {
    Optional<AlmacenProducto> findByAlmacenAndProducto(Almacen almacen, Producto producto);
}