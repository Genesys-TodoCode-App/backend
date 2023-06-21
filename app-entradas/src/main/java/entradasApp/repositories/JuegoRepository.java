package entradasApp.repositories;

import entradasApp.entities.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuegoRepository extends CrudRepository<Juego, Long> {

    @Query(value = "SELECT j.nombreJuego, COUNT(ve) " +
        "FROM Juego j JOIN j.entradas e JOIN e.ventasEntradas ve " +
        "WHERE ve.fechaVenta <= CURRENT_TIMESTAMP " +
        "GROUP BY j.nombreJuego " +
        "ORDER BY COUNT(ve) DESC " +
        "LIMIT 1", nativeQuery = true)
    Object[] findJuegoMasEntradasVendidasHastaHoy();


}
