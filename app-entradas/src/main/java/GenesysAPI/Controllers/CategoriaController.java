package GenesysAPI.Controllers;


import GenesysAPI.DTO.CategoriaDTO;
import GenesysAPI.Services.Interfaces.ICategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private  final ICategoriaService categoriaService;

    public CategoriaController (ICategoriaService categoriaService) {

        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<CategoriaDTO>> getCategoriaById(@PathVariable Integer id) {
        return categoriaService.findById(id)
                .thenApply(categoriaDTO -> {
                    if (categoriaDTO != null) {
                        return ResponseEntity.ok(categoriaDTO);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                });
    }

    @GetMapping
    public CompletableFuture<Iterable<CategoriaDTO>> getAllCategorias() {
        return categoriaService.findAll();
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<CategoriaDTO>> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.save(categoriaDTO)
                .thenApply(categoriaDTO1 -> ResponseEntity.status(HttpStatus.CREATED).body(categoriaDTO1));
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> deleteCategoria(@PathVariable Integer id) {
        return categoriaService.deleteById(id)
                .thenApply(ignored -> ResponseEntity.noContent().build());
    }

}
