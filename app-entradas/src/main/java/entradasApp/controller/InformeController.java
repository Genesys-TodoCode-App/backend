package entradasApp.controller;

import entradasApp.entities.Comprador;
import entradasApp.services.InformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Controlador para las operaciones relacionadas con los informes.
 * Proporciona endpoints para obtener diferentes informes relacionados con las ventas y asignaciones de juegos.
 * Este controlador está mapeado a la ruta "/informes".
 */
@RestController
@RequestMapping("/informes")
public class InformeController {


    private final InformeService informeService;

    /**
     * Constructor del controlador.
     * @param informeService Servicio de informes.
     */
    @Autowired
    public InformeController(InformeService informeService) {
        this.informeService = informeService;
    }


    /**
     * Método para obtener la lista de los compradores que han comprado un juego en una fecha específica.
     * @param fecha La fecha para la cual se desea obtener la lista de los compradores que han comprado un juego.
     * @return La lista de los compradores que han comprado un juego en la fecha especificada.
     */
    @GetMapping("/cantidad-entradas-vendidas-en-fecha")
    public ResponseEntity<Integer> countEntradasVendidasEnFecha(@RequestParam("fecha") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate fecha) {
        return ResponseEntity.ok(informeService.countEntradasVendidasEnFecha(fecha));
    }


    /**
     * Método para obtener el número de entradas vendidas para un juego en particular en una fecha específica.     *
     * @param idJuego El ID del juego para el cual se desea obtener el número de entradas vendidas.
     * @param fecha   La fecha para la cual se desea obtener el número de entradas vendidas.
     * @return El número de entradas vendidas para el juego y fecha especificados.
     */
    @GetMapping("/cantidad-entradas-vendidas-por-juego-y-fecha")
    public ResponseEntity<Integer> countEntradasVendidasPorJuegoYFecha(@RequestParam("juego") Long idJuego, @RequestParam("fecha") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate fecha) {
        return ResponseEntity.ok(informeService.countEntradasVendidasPorJuegoYFecha(idJuego, fecha));
    }


    /**
     * Método para obtener la suma de los montos de ventas en un mes y año específicos.
     *
     * @param mes  El número del mes para el cual se desea obtener la suma de los montos de ventas.
     * @param anio El año para el cual se desea obtener la suma de los montos de ventas.
     * @return La suma de los montos de ventas para el mes y año especificados.
     */
    @GetMapping("/sumatoria-montos-ventas-por-mes-anio")
    public ResponseEntity<BigDecimal> sumMontosVentasEnMesYAnio(@RequestParam("mes") int mes, @RequestParam("anio") int anio) {
        return ResponseEntity.ok(informeService.sumMontosVentasEnMesYAnio(mes, anio));
    }


    /**
     * Método para obtener la suma del monto total de ventas para una fecha específica.
     *
     * @param fecha La fecha para la cual se desea obtener la suma del monto de ventas.
     * @return La suma del monto de ventas para la fecha especificada.
     */
    @GetMapping("/sumatoria-monto-venta-por-dia")
    public ResponseEntity<BigDecimal> sumMontoVentaPorFecha(@RequestParam("fecha") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate fecha) {
        return ResponseEntity.ok(informeService.getTotalVentasPorFecha(fecha));
    }


    /**
     * Método para obtener una lista de empleados con los juegos asignados.
     *
     * @return Una lista de objetos que contienen información sobre los empleados y los juegos asignados.
     */
    @GetMapping("/lista-empleados-con-juegos-asignados")
    public ResponseEntity<List<Object[]>> findEmpleadosConJuegosAsignados() {
        return ResponseEntity.ok(informeService.findEmpleadosConJuegosAsignados());
    }


    /**
     * Método para obtener una lista de compradores con la mayor cantidad de entradas pagadas en un mes y año específicos.     *
     * @param mes  El número del mes para el cual se desea obtener los compradores con más entradas pagadas.
     * @param anio El año para el cual se desea obtener los compradores con más entradas pagadas.
     * @return Una lista de objetos Comprador que representan a los compradores con la mayor cantidad de entradas pagadas.
     */
    @GetMapping("/comprador-con-mas-entradas-compradas")
    public ResponseEntity<List<Comprador>> findCompradorMasEntradasPagadas(int mes, int anio) {
        return ResponseEntity.ok(informeService.findCompradorMasEntradas(mes, anio));
    }


    /**
     * Método para obtener una lista de juegos con la mayor cantidad de entradas vendidas hasta la fecha actual.     *
     * @return Una lista de objetos que contienen información sobre los juegos y la cantidad de entradas vendidas.
     */
    @GetMapping("/juego-con-mas-entradas-vendidas-hasta-hoy")
    public ResponseEntity<List<Object[]>> findJuegoMasEntradasVendidasHastaHoy() {
        return ResponseEntity.ok(informeService.findJuegoMasEntradasVendidasHastaHoy());
    }

}
