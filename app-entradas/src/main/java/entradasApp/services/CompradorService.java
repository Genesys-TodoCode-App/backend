package entradasApp.services;

import entradasApp.entities.Comprador;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompradorService {


    @Autowired
    private CompradorRepository compradorRepository;

    public CompradorService(CompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }
    public void createComprador(Comprador comprador) {
        boolean existeComprador = compradorRepository.existsById(comprador.getIdComprador());
        if (existeComprador){
            throw new ExisteEnBaseDeDatosExcepcion("Este comprador existe en base de datos");
        }
        compradorRepository.save(comprador);
    }

    public Iterable<Comprador> findAll() {
        return  compradorRepository.findAll();
    }

    public Comprador findById(Long id) {
        return compradorRepository.findById(id)
            .orElseThrow(()-> new NoEncontradoExcepcion("El Comprador con el id: " + id + "no fue encontrado."));
    }

    public void update(Long id, Comprador comprador){
        Comprador compradorExistente = compradorRepository.findById(id)
            .orElseThrow(()-> new NoEncontradoExcepcion("El Comprador con el id: " + id + "no fue encontrado."));
        compradorExistente.setNombreComprador(comprador.getNombreComprador());
        compradorExistente.setApellidoComprador(comprador.getNombreComprador());
        compradorExistente.setDniComprador(comprador.getDniComprador());
        compradorExistente.setCorreoElectronicoComprador(comprador.getCorreoElectronicoComprador());
        compradorExistente.setPaseDeOro(comprador.isPaseDeOro());
        compradorRepository.save(compradorExistente);
    }

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
