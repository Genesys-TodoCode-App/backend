package entradasApp.repositories;

import entradasApp.entities.Comprador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepository extends CrudRepository<Comprador, Long> {
}
