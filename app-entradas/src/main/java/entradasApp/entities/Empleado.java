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

    @Column(name = "nombre_empleados", length = 20)
    private String nombreEmpleado;

    @Column(name = "apellido_empleados", length = 20)
    private String apellidoEmpleado;

    @Column(name = "dni_empleados", length = 20)
    private String dniEmpleado;

    @Column(name = "rutas_a_la_fotos", length = 100)
    private String rutaALaFoto;

    @Column(name = "rol_empleados", length = 20)
    @Enumerated    (EnumType.STRING)
    private RolEmpleado rolEmpleado;

    @OneToOne
    @JoinColumn(name = "id_usuarios")
    private Usuario usuario;

}
