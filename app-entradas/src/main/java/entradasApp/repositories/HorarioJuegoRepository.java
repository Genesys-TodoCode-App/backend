package entradasApp.repositories;

import entradasApp.entities.HorarioJuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioJuegoRepository extends JpaRepository<HorarioJuego, Long> {
}
