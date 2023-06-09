# Spring Boot - App Entradas del parque de atracciones
## Descripción

- Spring Boot 3.1.0
- Java 17
- Maven 4.0.0
- React Vite

### Cuenta con las siguientes dependencias:

- Spring Web
- Spring Data JPA
- PostgreSQL
- Spring Boot DevTools
- Lombok
- OpenApi webmvc
- Docker Compose(para desarrollo)
- Validation I/O
- Jackson DataBind
- ModelMapper

### La estructura de la base de datos es la siguiente:


![UML Entradas TCP.png](..%2F..%2FUML%20Entradas%20TCP.png)


### Los endpoints de la aplicacion y sus métodos son los siguientes:

   Siempre partiendo de http://localhost:3000

- /login para get y post
- /login/{id} para delete, get y put
- /empleados para get y post
- /empleados/{id} para delete, get y put
- /compradores para get y post
- /compradores/{id} para delete, get y put
- /entradas para get y post
- /entradas/{id} para delete, get y put
- /horariojuego para get y post
- /horariojuego/{id} para delete, get y put
- /juego para get y post
- /juego/{id} para delete, get y put
- /venta-entrada para get y pos
- /venta-entrada para delete, get y put


    Los métodos especiales que solicita el cliente son tambien el localhost:3000


- /cantidad-entradas-vendidas-en-fecha
- /cantidad-entradas-vendidas-por-juego-y-fecha
- /sumatoria-montos-ventas-por-mes-anio
- /sumatoria-monto-venta-por-dia
- /lista-empleados-con-juegos-asignados
- /comprador-con-mas-entradas-compradas
- /juego-con-mas-entradas-vendidas-hasta-hoy

### Uso de la aplicación

- La aplicación tiene documentación generada por Javadoc en la carpeta principal deñ proyecto con nombre docs
- La entrada a la documentacion es a través de index.html
- Soft Delete: Si bien es necesario el borrado de los datos, por una cuestión de integridad de la base de datos se ha optado por hacer este tipo de borrado
- La base de datos contiene para pruebas informacion generada en determinados dias que son:

- Para hacer correr el backend es necesario tener instalado Docker, Docker Compose y tener el Docker Daemon corriendo.
- Luego se hace baja de GitHub y se hace correr en el IDE de su preferencia apretando el "play"


- Para correr el la aplicación:
  - Hay que tener Docker Compose, Docker y tener el Docker Daemon corriendo.
  - Se baja del repositorio de Github presente y se hace un ./mvn clean package -DskipTests para construir la imagen
  - Se hace un docker-compose up y a disfrutar!
  - La aplicacion tiene los usuarios en pares clave:valor
    - usuario1: contrasenia1    EMPLEADO_ADMINISTRATIVO
    - usuario2:contrasenia2    EMPLEADO_JUEGO  
    - el resto de usuarios hasta el 12
    - las entradas vendidas son del 19 al 23 de junio de 2023 para los informes
    - tambien se puede acceder mediante el deploy hecho en http://vps-3399115-x.dattaweb.com:3000/ 
