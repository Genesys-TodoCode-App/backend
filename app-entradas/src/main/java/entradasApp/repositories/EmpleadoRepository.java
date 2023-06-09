package entradasApp.repositories;

import entradasApp.entities.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad Empleado
 */
@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

    /**
     * Obtiene empleados con sus respectivos juegos asignados.
     * @return Una lista.
     */
    @Query("SELECT e.nombreEmpleado, e.apellidoEmpleado, j.nombreJuego " +
        "FROM Empleado e " +
        "JOIN e.juegos j")
    List<Object[]> obtenerNombresyApellidosEmpleadosYJuegos();

    /**
     * Obtiene todos los empleados paginados
     * @param pageable Paginación
     * @return Una lista de empleados
     */
    Page<Empleado> findAll(Pageable pageable);
}
