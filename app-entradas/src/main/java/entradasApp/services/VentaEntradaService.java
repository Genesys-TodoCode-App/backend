package entradasApp.services;

import entradasApp.dtos.CompradorDTO;
import entradasApp.dtos.VentaEntradaDTO;
import entradasApp.entities.Comprador;
import entradasApp.entities.VentaEntrada;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.VentaEntradaRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Clase de servicio que maneja las operaciones relacionadas con las ventas de entradas.
 */
@Service
public class VentaEntradaService {

    @Autowired
    private final VentaEntradaRepository ventaEntradaRepository;
    private final ModelMapper modelMapper;

    /**
     * Constructor de la clase VentaEntradaService
     *
     * @param ventaEntradaRepository Repositorio de ventas de entradas.
     * @param modelMapper
     */
    public VentaEntradaService(VentaEntradaRepository ventaEntradaRepository, ModelMapper modelMapper) {
        this.ventaEntradaRepository = ventaEntradaRepository;
        this.modelMapper = modelMapper;
    }


    /**
     * Crea una nueva venta de entrada.
     * @param ventaEntradaDTO La venta de entrada a crear.
     */
    public void create(@Valid VentaEntradaDTO ventaEntradaDTO) {
        VentaEntrada ventaEntrada = modelMapper.map(ventaEntradaDTO, VentaEntrada.class);
        boolean existeVentaEntrada = ventaEntradaRepository.existsById(ventaEntrada.getIdVentaEntrada());
        if (existeVentaEntrada) {
            throw new ExisteEnBaseDeDatosExcepcion("Ya existe esta venta de entradas en la base de datos");
        }
        ventaEntradaRepository.save(ventaEntrada);
    }


    /**
     * Obtiene todas las ventas de entradas y las devuelve en una lista.
     * @param pageable Parámetro de paginación.
     * @return Una lista de ventas de entradas.
     */
    public Page<VentaEntradaDTO> findAll(Pageable pageable) {
        Page<VentaEntrada> ventasEntradasPage = ventaEntradaRepository.findAll(pageable);
        return ventasEntradasPage.map((element) -> {
            VentaEntradaDTO ventaEntradaDTO = modelMapper.map(element, VentaEntradaDTO.class);
            ventaEntradaDTO.setIdVentaEntradas(element.getIdVentaEntrada());

            CompradorDTO compradorDTO = modelMapper.map(element.getCompradorEntrada(), CompradorDTO.class);
            compradorDTO.setIdComprador(element.getCompradorEntrada().getIdComprador()); // Asignar el ID del comprador al DTO
            ventaEntradaDTO.setCompradorEntrada(compradorDTO);
            return ventaEntradaDTO;
        });
    }



    /**
     * Busca una venta de entrada por su ID.
     * @param id El ID de la venta de entrada a buscar.
     * @return La venta de entrada encontrada.
     * @throws NoEncontradoExcepcion Si no se encuentra la venta de entrada.
     */
    public VentaEntradaDTO findById(Long id) {
        VentaEntrada ventaEntrada = ventaEntradaRepository.findById(id)
            .orElseThrow(() -> new NoEncontradoExcepcion("La venta de entrada con el id: " + id + " no ha sido encontrada"));
        return modelMapper.map(ventaEntrada, VentaEntradaDTO.class);
    }


    /**
     * Actualiza una venta de entrada existente.
     * @param id El ID de la venta de entrada a actualizar.
     * @param ventaEntradaDTO La venta de entrada con los nuevos datos.
     * @return La venta de entrada actualizada.
     * @throws NoEncontradoExcepcion Si no se encuentra la venta de entrada.
     */
    public VentaEntradaDTO update(Long id, VentaEntradaDTO ventaEntradaDTO) {
        VentaEntrada ventaEntradaExistente = ventaEntradaRepository.findById(id)
            .orElseThrow(() -> new NoEncontradoExcepcion("La venta de entradas con el id: " + id + " no ha sido encontrada"));

        Comprador comprador = modelMapper.map(ventaEntradaDTO.getCompradorEntrada(), Comprador.class);
        ventaEntradaExistente.setCompradorEntrada(comprador);

        VentaEntrada ventaEntradaActualizada = ventaEntradaRepository.save(ventaEntradaExistente);
        return modelMapper.map(ventaEntradaActualizada, VentaEntradaDTO.class);
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
