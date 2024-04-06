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
import java.util.Random;

/**
 * Clase que representa a un monstruo en el juego. El pueden moverse aleatoriamente entre cuartos.
 */
public class Monstruo extends NPC {
    private Random random = new Random();
    /**
     * Constructor de la clase Monstruo.
     * @param nombre El nombre del monstruo.
     */
    public Monstruo(String nombre, Cuarto cuartoActual) {
        super(nombre, cuartoActual);
    }
    public Monstruo(String nombre,Cuarto cuarto, String dialogo){
        super(nombre, cuarto, dialogo);
    }
    /**
     * Método que mueve al monstruo una sala aleatoria entre las salidas disponibles del cuarto actual.
     * @param cuartoActual El cuarto actual en el que se encuentra el monstruo
     */
    public void moverMonstruo(Cuarto cuartoActual) {
        // Obtiene las salidas disponibles del cuarto actual
        HashMap<Object, Cuarto> salidas = cuartoActual.getHashSalidas();
        
        // Verifica si hay al menos una salida disponible
        if (!salidas.isEmpty()) {
            // Genera un índice aleatorio dentro del rango de salidas disponibles
            int indiceAleatorio = random.nextInt(salidas.size());
            
            // Obtiene una lista de las salidas disponibles
            Object[] salidasArray = salidas.values().toArray();
            
            // Obtiene el cuarto al que el aldeano se moverá
            Cuarto nuevoCuarto = (Cuarto) salidasArray[indiceAleatorio];
            
            // Añade al aldeano a la nueva sala
            nuevoCuarto.agregarNPC(this);
            
            // Remueve al aldeano del cuarto actual
            cuartoActual.eliminarNPC(this.getNombre());
        }   
    }
}
