package entradasApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;

/**
 * ApiManejadorDeExcepciones contiene respuestas personalizadas a algunos errores.
 */
@ControllerAdvice
public class AppManejadorDeExcepciones extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoEncontradoExcepcion.class)
    public ResponseEntity<Object> handleEmpleadoNoEncontradoExcepcion(NoEncontradoExcepcion ex, WebRequest request) {
        return new ResponseEntity<>(new ApiErrorConfig(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExisteEnBaseDeDatosExcepcion.class)
    public ResponseEntity<Object> ExisteEnBaseDeDatosManejador(ExisteEnBaseDeDatosExcepcion ex, WebRequest request) {
        return new ResponseEntity<>(new ApiErrorConfig(ex.getMessage(), HttpStatus.CONFLICT, LocalDateTime.now()), HttpStatus.CONFLICT);
    }


}
