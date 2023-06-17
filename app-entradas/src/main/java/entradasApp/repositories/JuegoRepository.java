package entradasApp.repositories;

import entradasApp.entities.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends CrudRepository<Juego, Long> {
    Long getIdJuegoByIdJuego(Long idJuego);
}
