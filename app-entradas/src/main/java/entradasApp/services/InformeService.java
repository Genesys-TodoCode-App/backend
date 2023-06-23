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

    public Integer countEntradasVendidasEnFecha(LocalDateTime fecha) {
        return ventaEntradaRepository.findCantidadEntradasVendidasPorFecha(fecha);
    }

    public Integer countEntradasVendidasPorJuegoYFecha(Long idJuego, LocalDateTime fecha) {
        return ventaEntradaRepository.findCantidadEntradasVendidasPorJuegoYFecha(idJuego, fecha);
    }

    public BigDecimal sumMontosVentasEnMesYAnio(int mes, int anio) {
        return ventaEntradaRepository.getTotalVentasPorMesYAnio(mes, anio);
    }

    public BigDecimal getTotalVentasPorFecha(LocalDate fecha){
        return ventaEntradaRepository.getTotalVentasPorFecha(fecha);
    }
    public List<Object[]> findEmpleadosConJuegosAsignados() {
        return empleadoRepository.obtenerNombresyApellidosEmpleadosYJuegos();
    }



    public List<Comprador> findCompradorMasEntradas(int mes, int anio) {
        return compradorRepository.obtenerCompradorConMasEntradas(mes, anio);
    }

    public List<Object[]> findJuegoMasEntradasVendidasHastaHoy() {
        return ventaEntradaRepository.obtenerJuegoConMasEntradasVendidas();

    }

}
