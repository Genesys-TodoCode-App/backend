package entradasApp.controller;

import entradasApp.entities.Juego;
import entradasApp.repositories.JuegoRepository;
import entradasApp.services.InformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/informes")
public class InformeController {

    private final InformeService informeService;

    @Autowired
    public InformeController(InformeService informeService) {
        this.informeService = informeService;
    }

    @GetMapping("/entradas-vendidas-en-fecha")
    public Long countEntradasVendidasEnFecha(@RequestParam("fecha") LocalDateTime fecha) {
        return informeService.countEntradasVendidasEnFecha(fecha);
    }

    @GetMapping("/entradas-vendidas-por-juego-y-fecha")
    public Long countEntradasVendidasPorJuegoYFecha(@RequestParam("juego") Juego juego, @RequestParam("fecha") LocalDateTime fecha) {
        return informeService.countEntradasVendidasPorJuegoYFecha(juego, fecha);
    }

    @GetMapping("/sum-montos-ventas-en-fecha")
    public BigDecimal sumMontosVentasEnFecha(@RequestParam("fecha") LocalDate fecha) {
        return informeService.sumMontosVentasEnFecha(fecha);
    }

    @GetMapping("/sum-montos-ventas-en-mes-anio")
    public BigDecimal sumMontosVentasEnMesYAnio(@RequestParam("mes") int mes, @RequestParam("anio") int anio) {
        return informeService.sumMontosVentasEnMesYAnio(mes, anio);
    }

    @GetMapping("/juego-mas-entradas-vendidas")
    public List<Object[]> findJuegoMasEntradasVendidas() {
        return informeService.findJuegoMasEntradasVendidas();
    }


    @GetMapping("/empleados-con-juegos-asignados")
    public List<Object[]> findEmpleadosConJuegosAsignados() {
        return informeService.findEmpleadosConJuegosAsignados();
    }

    @GetMapping("/comprador-con-mas-entradas-pagadas")
    public List<Object[]> findCompradorMasEntradasPagadas(int mes, int anio) {
        return informeService.findCompradorMasEntradasPagadas(mes, anio);
    }

    @GetMapping("/juego-con-mas-entradas-vendidas-hasta-hoy")
    public Object[] findJuegoMasEntradasVendidasHastaHoy() {
        return informeService.findJuegoMasEntradasVendidasHastaHoy();
    }
}
