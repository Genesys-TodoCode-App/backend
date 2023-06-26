package entradasApp.repositories;

import entradasApp.entities.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Juego
 */
@Repository
public interface JuegoRepository extends JpaRepository<Juego, Long> {

}






