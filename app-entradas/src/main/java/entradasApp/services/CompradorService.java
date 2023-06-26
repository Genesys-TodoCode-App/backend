package entradasApp.services;

import entradasApp.entities.Comprador;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase de servicio que maneja las operaciones relacionadas con los compradores.
 */
@Service
public class CompradorService {


    @Autowired
    private final CompradorRepository compradorRepository;

    /**
     * Constructor de la clase CompradorService.
     * @param compradorRepository Repositorio de compradores.
     */
    public CompradorService(CompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }


    /**
     * Crea un nuevo comprador.
     * Si el comprador ya existe en la base de datos, se lanza una ExisteEnBaseDeDatosExcepcion.
     * @param comprador El comprador a crear.
     */
    public void createComprador(Comprador comprador) {
        boolean existeComprador = compradorRepository.existsById(comprador.getIdComprador());
        if (existeComprador) {
            throw new ExisteEnBaseDeDatosExcepcion("Este comprador existe en base de datos");
        }
        compradorRepository.save(comprador);
    }


    /**
     * Obtiene todos los compradores.
     * @return Una lista de todos los compradores.
     */
    public Iterable<Comprador> findAll() {
        return compradorRepository.findAll();
    }


    /**
     * Busca un comprador por su ID.
     * Si el comprador no existe, se lanza una NoEncontradoExcepcion.
     * @param id El ID del comprador a buscar.
     * @return El comprador encontrado.
     */
    public Comprador findById(Long id) {
        return compradorRepository.findById(id)
            .orElseThrow(() -> new NoEncontradoExcepcion("El Comprador con el id: " + id + "no fue encontrado."));
    }


    /**
     * Actualiza un comprador existente.
     * Si el comprador no existe, se lanza una NoEncontradoExcepcion.
     * @param id El ID del comprador a actualizar.
     * @param comprador El objeto comprador con los nuevos datos.
     */
    public void update(Long id, Comprador comprador) {
        Comprador compradorExistente = compradorRepository.findById(id)
            .orElseThrow(() -> new NoEncontradoExcepcion("El Comprador con el id: " + id + "no fue encontrado."));
        compradorExistente.setNombreComprador(comprador.getNombreComprador());
        compradorExistente.setApellidoComprador(comprador.getNombreComprador());
        compradorExistente.setDniComprador(comprador.getDniComprador());
        compradorExistente.setCorreoElectronicoComprador(comprador.getCorreoElectronicoComprador());
        compradorExistente.setPaseDeOro(comprador.isPaseDeOro());
        compradorRepository.save(compradorExistente);
    }


    /**
     * Elimina un comprador por su ID.
     * Si el comprador no existe, se lanza una RuntimeException.
     * @param id El ID del comprador a eliminar.
     */
    public void deleteById(Long id) {
        Comprador comprador = compradorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No encontrado el Comprador con el id: " + id));
        comprador.setPaseDeOro(false);
        comprador.setDniComprador(null);
        comprador.setNombreComprador(null);
        comprador.setApellidoComprador(null);
        comprador.setCorreoElectronicoComprador(null);
        compradorRepository.save(comprador);
    }


}
