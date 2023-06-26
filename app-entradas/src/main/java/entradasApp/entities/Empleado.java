package entradasApp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

/**
 * La clase Empleado representa al empleado que va a usar la aplicación.
 * Contiene anotaciones de Lombok, Jackson y JPA para la serialización de objetos.
 * OneToOne tiene un usuario asociado que sirve para autentificarse en la aplicación.
 * ManyToMany asocia a los juegos que el empleado puede interactuar
 * OneToMany asocia a las ventas de entradas realizadas por el empleado.
 */
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


    /** Esta es la relacion con el id del Usuario
     *
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;


    /**
     * Lista de juegos asignados al empleado.
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "empleados_juegos",
        joinColumns = @JoinColumn(name = "id_empleados"),
        inverseJoinColumns = @JoinColumn(name = "id_juegos"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_empleados", "id_juegos"})
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private List<Juego> juegos;


    /**
     * Lista de ventas de entradas realizadas por el empleado.
     */
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<VentaEntrada> ventasEntradas;
}

