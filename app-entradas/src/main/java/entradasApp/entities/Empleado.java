package entradasApp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "empleados")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleados")
    private Long idEmpleado;

    private String nombreEmpleado;

    private String apellidoEmpleado;

    @OneToOne
    @JoinColumn(name = "id_usuarios")
    private Usuario usuario;

}
