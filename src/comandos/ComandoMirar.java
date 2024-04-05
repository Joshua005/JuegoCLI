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
 * 
 */
public class ComandoMirar extends ComandoAbstracto {

    @Override
    public boolean ejecutar(Juego juego) { 
        juego.imprimir(juego.mirar());
        return true;
    }
}

