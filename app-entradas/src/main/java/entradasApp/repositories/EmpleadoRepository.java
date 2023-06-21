package entradasApp.repositories;

import entradasApp.entities.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
    @Query(value = "SELECT e.nombreEmpleado, j.nombreJuego FROM Empleado e JOIN e.juegos j", nativeQuery = true)
    List<Object[]> findEmpleadosConJuegosAsignados();

}
