package juego;


/*
 * Universidad Nacional de Itapua.
 * Proyecto Zork.
 *
 * Autor Original: Michael Kolling, Universidad de Monash
 * Version: 1.1
 * Date: March 2000
 * Copyright (c) Michael Kolling
 *
 * Nombre del Alumno: Josue Amin Vera Florentin
 *
 */

/**
 * La unica funcion de esta clase es contener el main().
 */
public class JugarJuego {

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.jugar();
    }
}
