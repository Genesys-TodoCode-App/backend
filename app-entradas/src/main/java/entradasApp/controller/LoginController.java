package entradasApp.controller;

import entradasApp.entities.Empleado;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping
    public ResponseEntity<String> login(@RequestParam String usuario, @RequestParam String contrasenia) {
        try {
            loginService.login(usuario, contrasenia);
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } catch (NoEncontradoExcepcion e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales de inicio de sesion incorrectas");
        }
    }
}

