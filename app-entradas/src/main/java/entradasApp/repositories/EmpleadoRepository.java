package entradasApp.repositories;

import entradasApp.entities.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
    Empleado findByUsuarioEmpleado(String usuarioEmpleado);
}
