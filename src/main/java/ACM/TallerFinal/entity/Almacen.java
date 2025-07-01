package ACM.TallerFinal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"Almacen\"")
@Data
@NoArgsConstructor
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idAlmacen\"")
    private Integer idAlmacen;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"idCiudadFK\"", nullable = false)
    private Ciudad ciudad;
}