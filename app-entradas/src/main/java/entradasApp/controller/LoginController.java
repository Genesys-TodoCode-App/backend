package entradasApp.controller;

import entradasApp.dtos.UsuarioLoginDTO;
import entradasApp.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Esta clase es el controlador para el login de usuarios
 */
@RestController
@RequestMapping("/login")
public class LoginController {


    private LoginService loginService;

    /**
     * Constructor de la clase
     * @param loginService El servicio de LoginService que se utilizará en el controlador.
     */
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    /**
     * Controlador para el login de usuarios
     * @param nombreUsuario se ingresa el nombre de usuario
     * @param contraseniaUsuario se ingresa la contraseña del usuario
     * @return un token de sesion y un nombre de usuario a través de un ResponseEntity con un Empleado DTO que protege la contraseña.
     */
    @PostMapping
    public ResponseEntity<UsuarioLoginDTO> login(@RequestParam String nombreUsuario,
                                                 @RequestParam String contraseniaUsuario) {
        ResponseEntity<UsuarioLoginDTO> response = loginService.login(nombreUsuario, contraseniaUsuario);

        if(response.getBody() != null) {
            return response;
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
