package entradasApp.entities;

/**
 * Enum que representa los roles de un empleado:
 * Empleado juego: Se encarga de registrar las ventas de entradas y los
 * datos de los juegos y sus horarios (ABML).
 * Empleado administrativo: Se encarga del registro (ABML) de los datos
 * de los futuros compradores al ingresar al parque, de los empleados y
 * de asignar los usuarios a cada uno de ellos.
 */
public enum RolEmpleado {


    /**
     * Rol del empleado encargado de registrar las ventas de entradas y los datos de los juegos y sus horarios (ABML).
     */
    EMPLEADO_JUEGO,
    /**
     * Rol del empleado encargado del registro (ABML) de los datos de los futuros compradores al ingresar al parque,
     * de los empleados y de asignar los usuarios a cada uno de ellos.
     */
    EMPLEADO_ADMINISTRATIVO
}
