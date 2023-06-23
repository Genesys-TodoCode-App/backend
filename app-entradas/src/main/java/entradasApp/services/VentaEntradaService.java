package entradasApp.services;

import entradasApp.entities.VentaEntrada;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.VentaEntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 * Clase de servicio que maneja las operaciones relacionadas con las ventas de entradas.
 */
@Service
public class VentaEntradaService {

    @Autowired
    private final VentaEntradaRepository ventaEntradaRepository;

    /**
     * Constructor de la clase VentaEntradaService
     * @param ventaEntradaRepository Repositorio de ventas de entradas.
     */
    public VentaEntradaService(VentaEntradaRepository ventaEntradaRepository) {
        this.ventaEntradaRepository = ventaEntradaRepository;
    }

    /**
     * Crea una nueva venta de entrada.
     * @param ventaEntrada La venta de entrada a crear.
     */
    public void create(VentaEntrada ventaEntrada) {
        boolean existeVentaEntrada = ventaEntradaRepository.existsById(ventaEntrada.getIdVentaEntrada());
        if (existeVentaEntrada) {
            throw new ExisteEnBaseDeDatosExcepcion("Ya existe esta venta de entradas en la base de datos");
        }
        ventaEntradaRepository.save(ventaEntrada);
    }

    /**
     * Obtiene todas las ventas de entradas.
     * @return Una colección de ventas de entradas.
     */
    public Iterable<VentaEntrada> findAll() {
        return ventaEntradaRepository.findAll();
    }

    /**
     * Busca una venta de entrada por su ID.
     * @param id El ID de la venta de entrada a buscar.
     * @return La venta de entrada encontrada.
     * @throws NoEncontradoExcepcion Si no se encuentra la venta de entrada.
     */
    public VentaEntrada findById(Long id) {
        return ventaEntradaRepository.findById(id).orElseThrow(() -> new NoEncontradoExcepcion("La venta de entrada con el id: " + id + " no ha sido encontrada"));
    }

    /**
     * Actualiza una venta de entrada existente.
     * @param id El ID de la venta de entrada a actualizar.
     * @param ventaEntrada La venta de entrada con los nuevos datos.
     * @return La venta de entrada actualizada.
     * @throws NoEncontradoExcepcion Si no se encuentra la venta de entrada.
     */
    public VentaEntrada update(Long id, VentaEntrada ventaEntrada) {
        VentaEntrada ventaEntradaExistente = ventaEntradaRepository
            .findById(id)
            .orElseThrow(() -> new NoEncontradoExcepcion("La venta de entradas con el id: " + id + " no ha sido encontrada"));
        ventaEntradaExistente.setIdVentaEntrada(ventaEntrada.getIdVentaEntrada());
        ventaEntradaExistente.setEntrada(ventaEntrada.getEntrada());
        ventaEntradaExistente.setMontoVenta(ventaEntrada.getMontoVenta());
        ventaEntradaExistente.setFechaVenta(ventaEntrada.getFechaVenta());

        return ventaEntradaRepository.save(ventaEntradaExistente);
    }

    /**
     * Elimina una venta de entrada por su ID.
     * @param id El ID de la venta de entrada a eliminar.
     */
    public void deleteById(Long id) {
        try {
            ventaEntradaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrió un error al eliminar la venta de entradas con el id: " + id);
        }
    }
}
