package entradasApp.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "empleado_juego")
@PrimaryKeyJoinColumn(name = "id_empleados")
public class EmpleadoJuego extends Empleado {

    private boolean atributoEspecificoEmpJuego;



    }


