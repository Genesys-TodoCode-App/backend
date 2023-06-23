package entradasApp.services;

import entradasApp.entities.Comprador;
import entradasApp.repositories.CompradorRepository;
import entradasApp.repositories.EmpleadoRepository;
import entradasApp.repositories.JuegoRepository;
import entradasApp.repositories.VentaEntradaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase de servicio que maneja los Informes Personalizados solicitados por TodoCodePark
 * Tiene por esta razon respositorios de entrada, juego, comprador y empleado y su constructor
 */
@Service
@Transactional
public class InformeService {

    private final VentaEntradaRepository ventaEntradaRepository;
    private final JuegoRepository juegoRepository;
    private final CompradorRepository compradorRepository;
    private final EmpleadoRepository empleadoRepository;

    /**
     * Constructor de la clase InformeService
     * @param ventaEntradaRepository
     * @param juegoRepository
     * @param compradorRepository
     * @param empleadoRepository
     */
    @Autowired
    public InformeService(VentaEntradaRepository ventaEntradaRepository, JuegoRepository juegoRepository, CompradorRepository compradorRepository, EmpleadoRepository empleadoRepository) {
        this.ventaEntradaRepository = ventaEntradaRepository;
        this.juegoRepository = juegoRepository;
        this.compradorRepository = compradorRepository;
        this.empleadoRepository = empleadoRepository;
    }

    /**
     * Devuelve la cantidad de entradas vendidas en una fecha específica.
     * @param fecha La fecha para la cual se desea contar las entradas vendidas.
     * @return El número de entradas vendidas en la fecha especificada.
     */
    public Integer countEntradasVendidasEnFecha(LocalDateTime fecha) {
        return ventaEntradaRepository.findCantidadEntradasVendidasPorFecha(fecha);
    }

    /**
     * Devuelve la cantidad de entradas vendidas para un juego específico en una fecha específica.
     * @param idJuego El ID del juego para el cual se desea contar las entradas vendidas.
     * @param fecha La fecha para la cual se desea contar las entradas vendidas.
     * @return El número de entradas vendidas para el juego y fecha especificados.
     */
    public Integer countEntradasVendidasPorJuegoYFecha(Long idJuego, LocalDateTime fecha) {
        return ventaEntradaRepository.findCantidadEntradasVendidasPorJuegoYFecha(idJuego, fecha);
    }

    /**
     * Devuelve la suma de los montos de todas las ventas realizadas en un mes y año específicos.
     * @param mes El número del mes para el cual se desea obtener la suma de los montos de ventas.
     * @param anio El año para el cual se desea obtener la suma de los montos de ventas.
     * @return La suma de los montos de ventas para el mes y año especificados.
     */
    public BigDecimal sumMontosVentasEnMesYAnio(int mes, int anio) {
        return ventaEntradaRepository.getTotalVentasPorMesYAnio(mes, anio);
    }

    /**
     * Devuelve el monto total de ventas realizadas en una fecha específica.
     * @param fecha La fecha para la cual se desea obtener el monto total de ventas.
     * @return El monto total de ventas para la fecha especificada.
     */
    public BigDecimal getTotalVentasPorFecha(LocalDate fecha) {
        return ventaEntradaRepository.getTotalVentasPorFecha(fecha);
    }

    /**
     * Devuelve una lista de objetos que contienen los nombres y apellidos de los empleados
     * junto con los juegos que les han sido asignados.
     * @return Una lista de objetos que contiene los nombres y apellidos de los empleados
     *         y los juegos asignados a cada uno de ellos.
     */
    public List<Object[]> findEmpleadosConJuegosAsignados() {
        return empleadoRepository.obtenerNombresyApellidosEmpleadosYJuegos();
    }

    /**
     * Devuelve una lista de compradores que han realizado la mayor cantidad de entradas
     * en un mes y año específicos.
     * @param mes El número del mes para el cual se desea obtener los compradores con más entradas.
     * @param anio El año para el cual se desea obtener los compradores con más entradas.
     * @return Una lista de compradores que han realizado la mayor cantidad de entradas en el mes y año especificados.
     */
    public List<Comprador> findCompradorMasEntradas(int mes, int anio) {
        return compradorRepository.obtenerCompradorConMasEntradas(mes, anio);
    }

    /**
     * Devuelve una lista de objetos que contienen el juego con la mayor cantidad de entradas vendidas hasta la fecha actual.
     * @return Una lista de objetos que contiene el juego con la mayor cantidad de entradas vendidas hasta la fecha actual.
     */
    public List<Object[]> findJuegoMasEntradasVendidasHastaHoy() {
        return ventaEntradaRepository.obtenerJuegoConMasEntradasVendidas();

    }

}
