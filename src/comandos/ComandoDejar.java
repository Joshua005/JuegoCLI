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
package comandos;
import juego.Juego;

/**
 *  Este comando deja los items de jugador en el cuarto
 */
public class ComandoDejar extends ComandoAbstracto {

    @Override
    public boolean ejecutar(Juego juego) {
        String itemNombre = (String) getPalabras().get(1);
        juego.dejarItems(itemNombre);
        return true;
    }
    
}
