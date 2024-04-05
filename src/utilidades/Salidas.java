/*
 * Universidad Nacional de Itapua.
 * Proyecto Zork.
 *
 * Autor Original: Michael Kolling, Universidad de Monash
 * Version: 1.1 * Date: March 2000
 * Copyright (c) Michael Kolling
 *
 * Nombre del Alumno: Josue Amin Vera Florentin
 *
 */package utilidades;

/**
 * La clase Salidas representa una salida desde un cuarto en una dirección específica.
 */
 public class Salidas {
    private Object direccion;
    private Cuarto cuarto;
    
    /**
     * Constructor de la clase Salidas.
     *
     * @param direccion La dirección de la salida.
     * @param cuarto    El cuarto al que se dirige la salida.
     */
    public Salidas(Object direccion, Cuarto cuarto) {
        this.direccion = direccion;
        this.cuarto = cuarto;
    }
    
    /**
     * Método para obtener la dirección de la salida.
     *
     * @return La dirección de la salida.
     */
    public Object getDireccion() {
        return direccion;
    }
    
    /**
     * Método para obtener el cuarto al que se dirige la salida.
     *
     * @return El cuarto al que se dirige la salida.
     */
    public Cuarto getCuarto() {
        return cuarto;
    }
}
