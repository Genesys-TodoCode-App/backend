package entradasApp.repositories;

import entradasApp.entities.Comprador;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CompradorRepository extends CrudRepository<Comprador, Long> {
    @Query(value = "SELECT c.nombreComprador, c.apellidoComprador, COUNT(ve) FROM Comprador c JOIN c.ventasEntradas ve WHERE YEAR(ve.fechaVenta) = :anio AND MONTH(ve.fechaVenta) = :mes GROUP BY c.nombreComprador, c.apellidoComprador ORDER BY COUNT(ve) DESC", nativeQuery = true)
    List<Object[]> findCompradorMasEntradas(@Param("mes") int mes, @Param("anio") int anio);


    @Query(value = "SELECT c.nombreComprador, c.apellidoComprador, COUNT(ve) " +
        "FROM Comprador c JOIN c.ventasEntradas ve " +
        "WHERE YEAR(ve.fechaVenta) = :anio AND MONTH(ve.fechaVenta) = :mes " +
        "AND ve.entrada.juego.cobroPaseOro = true AND ve.compradorEntrada.paseDeOro = true " +
        "GROUP BY c.nombreComprador, c.apellidoComprador " +
        "ORDER BY COUNT(ve) DESC", nativeQuery = true)
    List<Object[]> findCompradorMasEntradasPagadas(@Param("mes") int mes, @Param("anio") int anio);



}
