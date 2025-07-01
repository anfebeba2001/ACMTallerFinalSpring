package ACM.TallerFinal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"Usuario\"")
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idUsuario\"")
    private Integer idUsuario;

    @Column(name = "nombre", nullable = false, length = 32)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 32)
    private String apellido;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "\"fechaRegistro\"", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"idRolFK\"", nullable = false)
    private RolUsuario rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"idCiudadFK\"", nullable = false)
    private Ciudad ciudad;
}