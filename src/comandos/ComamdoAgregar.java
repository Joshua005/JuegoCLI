package comandos;
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
import juego.Juego;
/**
 *  Comando que hagrea los items al inventario del jugador
 */
public class ComamdoAgregar extends ComandoAbstracto {

    @Override
    public boolean ejecutar(Juego juego) {
        String itemCuarto = (String) getPalabras().get(1);
        juego.guardarItems(itemCuarto);
        return true;
    }
    
}
