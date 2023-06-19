package entradasApp.controller;

import entradasApp.entities.HorarioJuego;
import entradasApp.services.HorarioJuegoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horariojuego")
public class HorarioJuegoController {

    private HorarioJuegoService horarioJuegoService;


    public HorarioJuegoController(HorarioJuegoService horarioJuegoService) {
        this.horarioJuegoService = horarioJuegoService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody HorarioJuego horarioJuego){
        horarioJuegoService.create(horarioJuego);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Iterable<HorarioJuego>> findAll(){
        Iterable<HorarioJuego> listaHorarioJuegos = horarioJuegoService.findAll();
        return ResponseEntity.ok(listaHorarioJuegos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioJuego> findById(@PathVariable Long id){
        HorarioJuego horarioJuego = horarioJuegoService.findById(id);
        return ResponseEntity.ok(horarioJuego);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        horarioJuegoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
