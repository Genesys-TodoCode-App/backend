package entradasApp.repositories;

import entradasApp.entities.VentaEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Repositorio para la entidad VentaEntrada
 */
@Repository
public interface VentaEntradaRepository extends JpaRepository<VentaEntrada, Long> {
    /**
     * Método para obtener la cantidad de entradas vendidas por fecha.
     * @param fecha la fecha específica.
     * @return la cantidad de entradas vendidas.
     */
    @Query("SELECT COUNT(e) AS cantidadEntradasVendidas " +
        "FROM VentaEntrada e " +
        "WHERE FUNCTION('DATE', e.fechaVenta) = :fecha")
    Integer findCantidadEntradasVendidasPorFecha(@Param("fecha") LocalDateTime fecha);


    /**
     * Método para obtener la cantidad de entradas vendidas por fecha y juego.
     * @param juegoId el id del juego.
     * @param fecha la fecha específica.
     * @return la cantidad de entradas vendidas.
     */
    @Query("SELECT COUNT(v) AS cantidad_entradas_vendidas " +
        "FROM VentaEntrada v " +
        "WHERE v.entrada.juego.id = :juegoId " +
        "AND FUNCTION('DATE', v.fechaVenta) = :fecha")
    Integer findCantidadEntradasVendidasPorJuegoYFecha(@Param("juegoId") Long juegoId, @Param("fecha") LocalDateTime fecha);

    /**
     * Método para obtener la cantidad de entradas vendidas por mes y año.
     * @param mes el mes específico.
     * @param anio el año específico.
     * @return la cantidad de entradas vendidas.
     */
    @Query("SELECT SUM(v.montoVenta) AS totalVentas " +
        "FROM VentaEntrada v " +
        "WHERE EXTRACT(MONTH FROM v.fechaVenta) = :mes " +
        "AND EXTRACT(YEAR FROM v.fechaVenta) = :anio")
    BigDecimal getTotalVentasPorMesYAnio(@Param("mes") int mes, @Param("anio") int anio);

    /**
     * Metodo para obtener la cantidad de entradas vendidas por fecha.
     * @param fecha la fecha específica.
     * @return la cantidad de entradas vendidas.
     */
    @Query("SELECT SUM(v.montoVenta) AS totalVentas " +
        "FROM VentaEntrada v " +
        "WHERE FUNCTION('DATE', v.fechaVenta) = :fecha")
    BigDecimal getTotalVentasPorFecha(@Param("fecha") LocalDate fecha);

    /**
     * Metodo para obtener el juego que más entradas vendió.
     * @return el juego con más entradas vendidas.
     */
    @Query("SELECT v.entrada.juego, COUNT(v) AS cantidadEntradasVendidas " +
        "FROM VentaEntrada v " +
        "GROUP BY v.entrada.juego " +
        "ORDER BY cantidadEntradasVendidas DESC")
    List<Object[]> obtenerJuegoConMasEntradasVendidas();
}




