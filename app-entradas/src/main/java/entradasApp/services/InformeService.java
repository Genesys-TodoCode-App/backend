package entradasApp.services;

import entradasApp.entities.Juego;
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


@Service
@Transactional
public class InformeService {

    private final VentaEntradaRepository ventaEntradaRepository;
    private final JuegoRepository juegoRepository;
    private final CompradorRepository compradorRepository;

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public InformeService(VentaEntradaRepository ventaEntradaRepository, JuegoRepository juegoRepository, CompradorRepository compradorRepository, EmpleadoRepository empleadoRepository) {
        this.ventaEntradaRepository = ventaEntradaRepository;
        this.juegoRepository = juegoRepository;
        this.compradorRepository = compradorRepository;
        this.empleadoRepository = empleadoRepository;
    }

    public Long countEntradasVendidasEnFecha(LocalDateTime fecha) {
        return ventaEntradaRepository.countEntradasVendidasEnFecha(fecha);
    }

    public Long countEntradasVendidasPorJuegoYFecha(Juego juego, LocalDateTime fecha) {
        return ventaEntradaRepository.countEntradasVendidasPorJuegoYFecha(juego, fecha);
    }

    public BigDecimal sumMontosVentasEnFecha(LocalDate fecha) {
        return ventaEntradaRepository.sumMontosVentasEnFecha(fecha);
    }

    public BigDecimal sumMontosVentasEnMesYAnio(int mes, int anio) {
        return ventaEntradaRepository.sumMontosVentasEnMesYAnio(mes, anio);
    }

    public List<Object[]> findJuegoMasEntradasVendidas() {
        return ventaEntradaRepository.findJuegoMasEntradasVendidas();
    }

    public List<Object[]> findEmpleadosConJuegosAsignados() {
        return empleadoRepository.findEmpleadosConJuegosAsignados();
    }

    public List<Object[]> findCompradorMasEntradas(int mes, int anio) {
        return compradorRepository.findCompradorMasEntradas(mes, anio);
    }

    public List<Object[]> findCompradorMasEntradasPagadas(int mes, int anio) {
        return compradorRepository.findCompradorMasEntradasPagadas(mes, anio);
    }

    public Object[] findJuegoMasEntradasVendidasHastaHoy() {
        return juegoRepository.findJuegoMasEntradasVendidasHastaHoy();

    }
}
