package entradasApp.repositories;

import entradasApp.entities.VentaEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaEntradaRepository extends CrudRepository<VentaEntrada, Long> {
}
