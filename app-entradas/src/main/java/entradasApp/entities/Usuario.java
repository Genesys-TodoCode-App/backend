package entradasApp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase Usuario representa una entidad de usuario en el sistema.
 * Contiene información sobre el usuario, como su identificador, nombre de usuario,
 * contraseña de usuario, contraseña de empleado y rol de empleado.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id Usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario", length = 20, unique = true)
    @JsonProperty("Nombre Usuario")
    private String nombreUsuario;

    @Column(name = "contrasenia_usuario", length = 20)
    @JsonProperty("Contrasenia Usuario")
    private String contraseniaUsuario;

    @Column(name = "rol_usuario", length = 40)
    @Enumerated(EnumType.STRING)
    @JsonProperty("Rol Usuario")
    private RolEmpleado rolEmpleado;
}
