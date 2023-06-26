package entradasApp.services;

import entradasApp.dtos.EmpleadoLoginDTO;
import entradasApp.entities.Usuario;
import entradasApp.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.UUID;

/**
 * Esta clase es el servicio de Login, devuelve un token de sesion y un nombre de usuario.
 */
@Service
public class LoginService {

    private UsuarioRepository usuarioRepository;


    /**
     * Constructor de la clase LoginService.
     * @param usuarioRepository Repositorio de usuarios.
     */
    @Autowired
    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    /**
     * Este método se encarga de registrarse y devolver un token de sesion y un nombre de usuario.
     * Hace comprobaciones en base de datos sobre usuario y contraseña.
     * Tiene un método que genera un token de sesion aleatorio.
     * @param nombreUsuario el nombre del usuario.
     * @param contraseniaUsuario la contraseña del usuario.
     * @return un token de sesion y un nombre de usuario a través de un ResponseEntity con un Empleado DTO que protege la contraseña.
     */
    public ResponseEntity<EmpleadoLoginDTO> login(String nombreUsuario, String contraseniaUsuario) {
        Usuario existeUsuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        if (existeUsuario != null) {
            if (existeUsuario.getContraseniaUsuario().equals(contraseniaUsuario)){
                String tokenSesion = generarTokenSesion(existeUsuario);
                String nombreUsuarioCookie = existeUsuario.getNombreUsuario();
                int validezCookieEnSegundos = 86_000;

                EmpleadoLoginDTO empleadoLoginDTO = new EmpleadoLoginDTO();
                empleadoLoginDTO.setUsuarioEmpleado(existeUsuario.getNombreUsuario());
                empleadoLoginDTO.setRolEmpleado(existeUsuario.getRolEmpleado());
                empleadoLoginDTO.setTokenDeSesion(tokenSesion);
                empleadoLoginDTO.setMensaje("Password correcto");

                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.add(HttpHeaders.SET_COOKIE, "token" + tokenSesion + "; Max-Age=" + validezCookieEnSegundos + "; HttpOnly");
                httpHeaders.add(HttpHeaders.SET_COOKIE, "nombreUsuario" + nombreUsuarioCookie + "; Max-Age=" + validezCookieEnSegundos);
                return ResponseEntity.ok().headers(httpHeaders).body(empleadoLoginDTO);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new EmpleadoLoginDTO(nombreUsuario, null, null, "Credeciales incorrectas, verifica los datos."));
    }

    /**
     * Método que genera un token de sesion aleatorio.
     * @param usuario el usuario a generar el token de sesion.
     * @return un token de sesion.
     */
    private String generarTokenSesion(Usuario usuario) {
        String token = UUID.randomUUID().toString();
        return token;
    }
}
