package entradasApp.services;

import entradasApp.entities.VentaEntrada;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.VentaEntradaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaEntradaService {

    private final VentaEntradaRepository ventaEntradaRepository;

    public VentaEntradaService(VentaEntradaRepository ventaEntradaRepository) {
        this.ventaEntradaRepository = ventaEntradaRepository;
    }

    public void create(VentaEntrada ventaEntrada) {
        boolean existeVentaEntrada = ventaEntradaRepository.existsById(ventaEntrada.getIdVentaEntrada());
        if (existeVentaEntrada) {
            throw new ExisteEnBaseDeDatosExcepcion("Ya existe esta venta de entradas en la base de datos");
        }
        ventaEntradaRepository.save(ventaEntrada);
    }

    public List<VentaEntrada> findAll() {
        return ventaEntradaRepository.findAll();
    }

    public VentaEntrada findById(Long id) {
        return ventaEntradaRepository.findById(id)
            .orElseThrow(() -> new NoEncontradoExcepcion("La venta de entrada con el id: " + id + " no ha sido encontrada"));
    }

    public VentaEntrada update(Long id, VentaEntrada ventaEntrada) {
        VentaEntrada ventaEntradaExistente = ventaEntradaRepository.findById(id)
            .orElseThrow(() -> new NoEncontradoExcepcion("La venta de entradas con el id: " + id + " no ha sido encontrada"));

        ventaEntradaExistente.setIdVentaEntrada(ventaEntrada.getIdVentaEntrada());
        ventaEntradaExistente.setEntrada(ventaEntrada.getEntrada());
        ventaEntradaExistente.setMontoVenta(ventaEntrada.getMontoVenta());
        ventaEntradaExistente.setFechaVenta(ventaEntrada.getFechaVenta());

        return ventaEntradaRepository.save(ventaEntradaExistente);
    }

    public void deleteById(Long id) {
        try {
            ventaEntradaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrió un error al eliminar la venta de entradas con el id: " + id);
        }
    }
}
