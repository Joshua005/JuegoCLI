package comandos;

import juego.Juego;

/**
 * Este comando sirve para poder hablar con los personajes
 */
public class ComandoHablar extends ComandoAbstracto {
    @Override
    public boolean ejecutar(Juego juego) {
        String hablar = (String) getPalabras().get(1);
        juego.imprimir(juego.hablar(hablar));
        
        return true;
    }

    
}
