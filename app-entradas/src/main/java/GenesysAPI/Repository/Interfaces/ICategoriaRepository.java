package GenesysAPI.Repository.Interfaces;

import GenesysAPI.Models.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface ICategoriaRepository extends CrudRepository<Categoria, Integer> {



    // Método para editar una categoría existente
    default Categoria editarCategoria(Categoria categoria) {
        return save(categoria);
    }

}
