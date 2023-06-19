package entradasApp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "empleados")
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

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
        name = "empleados_juegos",
        joinColumns = @JoinColumn(name = "id_empleados"),
        inverseJoinColumns = @JoinColumn(name = "id_juegos")
    )
    private List<Juego> juegos;

}
