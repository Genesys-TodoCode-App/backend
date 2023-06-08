package GenesysAPI.Services.Implementacion;


import GenesysAPI.DTO.CategoriaDTO;
import GenesysAPI.Models.Categoria;
import GenesysAPI.Repository.Interfaces.ICategoriaRepository;
import GenesysAPI.Services.Interfaces.ICategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;



@Service
public class CategoriaServiceImpl implements ICategoriaService {

    private final ICategoriaRepository _icategoriaRepository;
    private final ModelMapper modelMapper;

    public CategoriaServiceImpl (ICategoriaRepository _icategoriaRepository, ModelMapper modelMapper){

        this._icategoriaRepository = _icategoriaRepository;
        this.modelMapper = modelMapper;

    }


    @Override
    public CompletableFuture<CategoriaDTO> findById(Integer id_categoria) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<Categoria> optionalCategoria = _icategoriaRepository.findById(id_categoria);
            return optionalCategoria.map(categoria -> modelMapper.map(categoria, CategoriaDTO.class)).orElse(null);
        });
    }

    @Override
    public CompletableFuture<Iterable<CategoriaDTO>> findAll() {
        return CompletableFuture.supplyAsync(() -> {
            Iterable<Categoria> categorias = _icategoriaRepository.findAll();
            return mapToCategoriaDTOs(categorias);
        });
    }

    @Override
    public CompletableFuture<CategoriaDTO> save(CategoriaDTO categoriaDTO) {
        Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);
        return CompletableFuture.supplyAsync(() -> {
            Categoria savedCategoria = _icategoriaRepository.save(categoria);
            return modelMapper.map(savedCategoria, CategoriaDTO.class);
        });
    }

    @Override
    public CompletableFuture<Void> deleteById(Integer id_categoria) {
        return CompletableFuture.runAsync(() -> _icategoriaRepository.deleteById(id_categoria));
    }

    private Iterable<CategoriaDTO> mapToCategoriaDTOs(Iterable<Categoria> categorias) {
        List<CategoriaDTO> categoriaDTOs = new ArrayList<>();
        categorias.forEach(categoria -> {
            CategoriaDTO categoriaDTO = modelMapper.map(categoria, CategoriaDTO.class);
            categoriaDTOs.add(categoriaDTO);
        });
        return categoriaDTOs;
    }
}
