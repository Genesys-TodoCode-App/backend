package entradasApp.repositories;

import entradasApp.entities.Comprador;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad Comprador
 */
@Repository
@Transactional
public interface CompradorRepository extends CrudRepository<Comprador, Long> {
    /**
     * Obtiene una lista de compradores que tienen más entradas vendidas en el mes y año especificados
     * @param mes el mes específico.
     * @param anio el año específico.
     * @return Una lista de compradores con la maxima cantidad de entradas vendidas.
     */
    @Query(value = "SELECT c FROM Comprador c " +
        "JOIN VentaEntrada ve ON c.idComprador = ve.compradorEntrada.idComprador " +
        "WHERE EXTRACT(MONTH FROM ve.fechaVenta) = :mes " +
        "AND EXTRACT(YEAR FROM ve.fechaVenta) = :anio " +
        "GROUP BY c.idComprador, c.nombreComprador, c.apellidoComprador " +
        "ORDER BY COUNT(*) DESC")
    List<Comprador> obtenerCompradorConMasEntradas(@Param("mes") int mes, @Param("anio") int anio);

}
