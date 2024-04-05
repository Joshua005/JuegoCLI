package utilidades;
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
 */

/**
 * La clase Item representa un objeto que puede ser encontrado, recogido y utilizado en el juego.
 * Cada ítem tiene un nombre, una descripción y un tamaño que determina cuánto espacio ocupa
 * en el inventario del jugador.
 */
public class Item {
    private int tamnho;
    private String nombre;
    private String descripcion = "";
    /**
     * Constructor de la clase Item.
     *
     * @param nombre      El nombre del ítem.
     * @param descripcion La descripción del ítem.
     * @param tamnho      El tamaño del ítem en el inventario.
     */
    public Item(String nombre, String descripcion, int tamnho) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamnho = tamnho;
    }

    /**
     * Obtiene el nombre del ítem.
     *
     * @return El nombre del ítem.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la descripción del ítem.
     *
     * @return La descripción del ítem.
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Obtiene el tamaño del ítem en el inventario.
     *
     * @return El tamaño del ítem en el inventario.
     */
    public int getTamnho() {
        return tamnho;
    }
}

