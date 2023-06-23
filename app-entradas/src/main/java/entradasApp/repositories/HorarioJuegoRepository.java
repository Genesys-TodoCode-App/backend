package entradasApp.repositories;

import entradasApp.entities.HorarioJuego;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioJuegoRepository extends CrudRepository<HorarioJuego, Long> {

}
