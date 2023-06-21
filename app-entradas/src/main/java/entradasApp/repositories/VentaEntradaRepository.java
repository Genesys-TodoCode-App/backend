package entradasApp.repositories;

import entradasApp.entities.Juego;
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

    @Query(value = "SELECT COUNT(ve) FROM VentaEntrada ve WHERE ve.fechaVenta = :fecha", nativeQuery = true)
    Long countEntradasVendidasEnFecha(@Param("fecha") LocalDateTime fecha);

    @Query(value = "SELECT COUNT(ve) FROM VentaEntrada ve WHERE ve.entrada.juego = :juego AND ve.fechaVenta = :fecha", nativeQuery = true)
    Long countEntradasVendidasPorJuegoYFecha(@Param("juego") Juego juego, @Param("fecha") LocalDateTime fecha);

    @Query(value = "SELECT SUM(CASE WHEN ve.compradorEntrada.paseDeOro = true AND ve.entrada.juego.paseDeOro = true THEN 0 ELSE ve.montoVenta END) FROM VentaEntrada ve WHERE ve.fechaVenta = :fecha", nativeQuery = true)
    BigDecimal sumMontosVentasEnFecha(@Param("fecha") LocalDate fecha);

    @Query(value = "SELECT SUM(CASE WHEN ve.compradorEntrada.paseDeOro = true AND ve.entrada.juego.paseDeOro = true THEN 0 ELSE ve.montoVenta END) FROM VentaEntrada ve WHERE YEAR(ve.fechaVenta) = :anio AND MONTH(ve.fechaVenta) = :mes", nativeQuery = true)
    BigDecimal sumMontosVentasEnMesYAnio(@Param("mes") int mes, @Param("anio") int anio);

    @Query(value = "SELECT j.nombreJuego, COUNT(ve) FROM Juego j JOIN j.horarios h JOIN h.entradas ve WHERE ve.fechaHoraUtilizacion <= CURRENT_TIMESTAMP GROUP BY j.nombreJuego ORDER BY COUNT(ve) DESC", nativeQuery = true)
    List<Object[]> findJuegoMasEntradasVendidas();

}

