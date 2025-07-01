package ACM.TallerFinal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"Categoria\"")
@Data
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idCategoria\"")
    private Integer idCategoria;

    @Column(name = "nombre", nullable = false)
    private String nombre;
}
