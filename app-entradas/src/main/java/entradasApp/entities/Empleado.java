package entradasApp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleados", unique = true, updatable = false)
    private Long idEmpleado;

    @Column(name = "nombre_empleados", length = 20)
    private String nombreEmpleado;

    @Column(name = "apellido_empleados", length = 20)
    private String apellidoEmpleado;

    @Column(name = "dni_empleados", length = 20)
    private String dniEmpleado;

    @Column(name = "rutas_a_la_fotos", length = 100)
    private String rutaALaFoto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "empleados_juegos",
        joinColumns = @JoinColumn(name = "id_empleados"),
        inverseJoinColumns = @JoinColumn(name = "id_juegos"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_empleados", "id_juegos"})
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Juego> juegos;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<VentaEntrada> ventasEntradas;
}

