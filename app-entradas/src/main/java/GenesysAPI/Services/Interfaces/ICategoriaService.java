package GenesysAPI.Services.Interfaces;

import GenesysAPI.DTO.CategoriaDTO;

import java.util.concurrent.CompletableFuture;

public interface ICategoriaService {

    CompletableFuture<CategoriaDTO> findById(Integer id_categoria);
    CompletableFuture<Iterable<CategoriaDTO>> findAll();
    CompletableFuture<CategoriaDTO> save(CategoriaDTO categoriaDTO);
    CompletableFuture<Void> deleteById(Integer id_categoria);

}
