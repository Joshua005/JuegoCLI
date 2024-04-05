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
 * 
 */
 public class Salidas {
    private Object direccion;
    private Cuarto cuarto;
    /**
     * 
     * @param direccion
     * @param cuarto
     */
    public Salidas(Object direccion, Cuarto cuarto) {
        this.direccion = direccion;
        this.cuarto = cuarto;
    }
    /**
     * 
     * @return
     */
    public Object getDireccion() {
        return direccion;
    }
    /**
     * s
     * @return
     */
    public Cuarto getCuarto() {
        return cuarto;
    }
}
