package entradasApp.repositories;

import entradasApp.entities.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la entidad Entrada
 */
@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {

}
