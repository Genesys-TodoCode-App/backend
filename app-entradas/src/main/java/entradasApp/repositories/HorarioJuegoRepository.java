package entradasApp.repositories;

import entradasApp.entities.HorarioJuego;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad HorarioJuego
 */
@Repository
public interface HorarioJuegoRepository extends CrudRepository<HorarioJuego, Long> {

}
