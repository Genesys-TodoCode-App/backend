package entradasApp.repositories;

import entradasApp.entities.Entrada;
import entradasApp.entities.VentaEntrada;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface VentaEntradaRepository extends CrudRepository<VentaEntrada, Long> {

    @Query("SELECT COUNT(e) AS cantidadEntradasVendidas " +
        "FROM VentaEntrada e " +
        "WHERE FUNCTION('DATE', e.fechaVenta) = :fecha")
    Integer findCantidadEntradasVendidasPorFecha(@Param("fecha") LocalDateTime fecha);


    @Query("SELECT COUNT(v) AS cantidad_entradas_vendidas " +
        "FROM VentaEntrada v " +
        "WHERE v.entrada.juego.id = :juegoId " +
        "AND FUNCTION('DATE', v.fechaVenta) = :fecha")
    Integer findCantidadEntradasVendidasPorJuegoYFecha(@Param("juegoId") Long juegoId, @Param("fecha") LocalDateTime fecha);

    @Query("SELECT SUM(v.montoVenta) AS totalVentas " +
        "FROM VentaEntrada v " +
        "WHERE EXTRACT(MONTH FROM v.fechaVenta) = :mes " +
        "AND EXTRACT(YEAR FROM v.fechaVenta) = :anio")
    BigDecimal getTotalVentasPorMesYAnio(@Param("mes") int mes, @Param("anio") int anio);

    @Query("SELECT SUM(v.montoVenta) AS totalVentas " +
        "FROM VentaEntrada v " +
        "WHERE FUNCTION('DATE', v.fechaVenta) = :fecha")
    BigDecimal getTotalVentasPorFecha(@Param("fecha") LocalDate fecha);



        @Query("SELECT v.entrada.juego, COUNT(v) AS cantidadEntradasVendidas " +
            "FROM VentaEntrada v " +
            "GROUP BY v.entrada.juego " +
            "ORDER BY cantidadEntradasVendidas DESC")
        List<Object[]> obtenerJuegoConMasEntradasVendidas();
    }




