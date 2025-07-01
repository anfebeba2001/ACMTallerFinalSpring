package ACM.TallerFinal.repository;

import ACM.TallerFinal.entity.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {
}