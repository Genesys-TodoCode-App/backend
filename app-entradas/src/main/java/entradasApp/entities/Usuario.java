package entradasApp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(name = "nombre_usuario", length = 20, unique = true)
    private String nombreUsuario;

    @Column(name = "contrasenia_usuario", length = 20)
    private String contraseniaEmpleado;

    @Column(name = "rol_usuario", length = 40)
    @Enumerated(EnumType.STRING)
    private RolEmpleado rolEmpleado;
}
