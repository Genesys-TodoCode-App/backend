package GenesysAPI.Repository.Interfaces;

import GenesysAPI.Models.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.concurrent.CompletableFuture;


public interface ICategoriaRepository extends CrudRepository<Categoria, Integer> {

    default CompletableFuture<Categoria> findByIdAsync(Integer id_categoria) {
        return CompletableFuture.supplyAsync(() -> findById(id_categoria).orElse(null));
    }

    default CompletableFuture<Iterable<Categoria>> findAllAsync() {
        return CompletableFuture.supplyAsync(this::findAll);
    }

    default CompletableFuture<Categoria> saveAsync(Categoria categoria) {
        return CompletableFuture.supplyAsync(() -> save(categoria));
    }

    //Editar la categoria
    default CompletableFuture<Categoria> updateAsync(Categoria categoria) {
        return CompletableFuture.supplyAsync(() -> save(categoria));
    }

    boolean existsByNombre (String nombre);

    default CompletableFuture<Void> deleteByIdAsync(Integer id_categoria) {
        return CompletableFuture.runAsync(() -> deleteById(id_categoria));
    }


}
