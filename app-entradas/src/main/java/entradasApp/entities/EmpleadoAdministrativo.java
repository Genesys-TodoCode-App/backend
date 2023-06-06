package entradasApp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name= "empleados_administrativos")
@PrimaryKeyJoinColumn(name = "id_empleados")
public class EmpleadoAdministrativo extends Empleado{

    private boolean atributoEspecificoEmpAdmin;

}
