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

import java.util.HashMap;
import java.util.Map;

/**
 * La clase Mapa representa un objeto que contiene información sobre la disposición de los cuartos
 * en un juego o entorno virtual. Cada instancia de Mapa puede contener un conjunto de cuartos
 * asociados a nombres específicos.
 */
public class Mapa extends Item {
    private Map<String, Cuarto> cuartos;

    /**
     * Constructor de la clase Mapa.
     *
     * @param nombre      El nombre del mapa.
     * @param descripcion La descripción del mapa.
     */
    public Mapa(String nombre, String descripcion) {
        super(nombre, descripcion, 3); 
        this.cuartos = new HashMap<>();
    }

    /**
     * Agrega un cuarto al mapa.
     *
     * @param nombre El nombre asociado al cuarto en el mapa.
     * @param cuarto El cuarto que se va a agregar al mapa.
     */    
    public void agregarCuarto(String nombre, Cuarto cuarto) {
        cuartos.put(nombre, cuarto);
    }

    /**
     * Obtiene un cuarto del mapa por su nombre.
     *
     * @param nombre El nombre del cuarto que se desea obtener.
     * @return El cuarto asociado al nombre especificado, o null si no se encuentra en el mapa.
     */
    public Cuarto getCuarto(String nombre) {
        return cuartos.get(nombre);
    }

    
    
}
