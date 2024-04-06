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
 * Este comando da un breve comentario sobre la historia del juego al jugador
 * @author joshua
 */
 public class ComandoInicio extends ComandoAbstracto {

    /**
     * 
     * @param juego
     * @return
     */
    @Override
    public boolean ejecutar(Juego juego) {
        juego.imprimir("Mientras escapabas de la policia te metes en un deposito abandonado, tropiezas y te golpeas fuertemente tu cabeza.");
        juego.imprimir("Al despertar ya no reconoces el lugar, recoriendo un poco encuentras un pedazo de mapa el cual parece llevar a la salida,");
        juego.imprimir("pero tambien abvierte que no estas solo en aquel lugar.");
        System.out.println(juego.mirarDescripcionCuarto());
        return true;
    }
    
}
