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
 *  Mueve al jugador al cuarto anterior he imprime la descripcion del cuarto en cuestion
 */
public class ComandoAtras extends ComandoAbstracto {

    /**
     *
     * @param juego
     * @return
     */
    @Override
    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() > 4) {
            throw new IllegalArgumentException("Donde quiieres ir?");
        }
        juego.atras();
        return true;
    }

  
    
}
