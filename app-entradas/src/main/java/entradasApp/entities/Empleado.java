package entradasApp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "empleados")
@Inheritance(strategy = InheritanceType.JOINED)
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleados", nullable = false,  unique = true, updatable = false)
    private Long idEmpleado;

    @Column(name = "usuario_empleados", length = 20, unique = true)
    private String usuarioEmpleado;

    @Column(name = "contrasenia_empleados", length = 20)
    private String contraseniaEmpleado;

    @Column(name = "nombre_empleados", length = 20)
    private String nombreEmpleado;

    @Column(name = "apellido_empleados", length = 20)
    private String apellidoEmpleado;

    @Column(name = "dni_empleados", length = 20)
    private String dniEmpleado;

    @Column(name = "rutas_a_la_fotos", length = 100)
    private String rutaALaFoto;

    @Column(name = "rol_empleados", length = 40)
    @Enumerated    (EnumType.STRING)
    private RolEmpleado rolEmpleado;


}
