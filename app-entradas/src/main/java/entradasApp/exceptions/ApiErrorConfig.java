package entradasApp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

/**
 * ApiErrorConfig define el tipo de respuesta que va a recibir el cliente.
 * Incluye un mensaje, un HttpStatus y un timestamp.
 */
@Data
@AllArgsConstructor
public class ApiErrorConfig {

    private String mensaje;

    private HttpStatus httpStatus;

    private LocalDateTime timeStamp;
}
