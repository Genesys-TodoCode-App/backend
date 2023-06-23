package entradasApp.controller;

import entradasApp.entities.Comprador;
import entradasApp.services.InformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/informes")
public class InformeController {

    private final InformeService informeService;

    @Autowired
    public InformeController(InformeService informeService) {
        this.informeService = informeService;
    }

    @GetMapping("/entradas-vendidas-en-fecha")
    public Integer countEntradasVendidasEnFecha(@RequestParam("fecha") LocalDateTime fecha) {
        return informeService.countEntradasVendidasEnFecha(fecha);
    }

    @GetMapping("/entradas-vendidas-por-juego-y-fecha")
    public Integer countEntradasVendidasPorJuegoYFecha(@RequestParam("juego") Long idJuego, @RequestParam("fecha") LocalDateTime fecha) {
        return informeService.countEntradasVendidasPorJuegoYFecha(idJuego, fecha);
    }



    @GetMapping("/sum-montos-ventas-en-mes-anio")
    public BigDecimal sumMontosVentasEnMesYAnio(@RequestParam("mes") int mes, @RequestParam("anio") int anio) {
        return informeService.sumMontosVentasEnMesYAnio(mes, anio);
    }

    @GetMapping("/sum-monto-venta-por-fecha")
    public BigDecimal sumMontoVentaPorFecha(@RequestParam("fecha") LocalDate fecha) {
        return informeService.getTotalVentasPorFecha(fecha);
    }


    @GetMapping("/empleados-con-juegos-asignados")
    public List<Object[]> findEmpleadosConJuegosAsignados() {
        return informeService.findEmpleadosConJuegosAsignados();
    }

    @GetMapping("/comprador-con-mas-entradas-pagadas")
    public List<Comprador> findCompradorMasEntradasPagadas(int mes, int anio) {
        return informeService.findCompradorMasEntradas(mes, anio);
    }

    @GetMapping("/juego-con-mas-entradas-vendidas-hasta-hoy")
    public List<Object[]> findJuegoMasEntradasVendidasHastaHoy() {
        return informeService.findJuegoMasEntradasVendidasHastaHoy();
    }

}
