package ACM.TallerFinal.repository;

import ACM.TallerFinal.entity.ProductoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCategoriaRepository extends JpaRepository<ProductoCategoria, Integer> {
}