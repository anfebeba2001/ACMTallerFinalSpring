package ACM.TallerFinal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"RolUsuario\"")
@Data
@NoArgsConstructor
public class RolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idRol\"")
    private Integer idRol;

    @Column(name = "rol", nullable = false, unique = true)
    private String rol;
}