package comandos;
import java.util.List;

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
        StringBuilder sd = new StringBuilder();
        List itemCuarto =  getPalabras();
        for (int i=1; itemCuarto.size()>i;i++) {
            if (itemCuarto.get(i)== null){
                break;
            }
            else sd = sd.append(itemCuarto.get(i));
        }
        juego.guardarItems(sd.toString());
        return true;
    }
    
}
