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
 * La clase NPC representa a un Personaje No Jugador en el juego, que puede tener diálogos con el jugador.
 */
public class NPC {
    private String nombre;
    private Map<String, String> dialogos;
    private Cuarto cuartoActual;
    public NPC(String nombre) {
        this.nombre = nombre;
        this.dialogos = new HashMap<>();
    }
    
    /**
     * Constructor de la clase NPC que recibe el nombre del NPC y el cuarto actual en el que se encuentra.
     *
     * @param nombre       El nombre del NPC.
     * @param cuartoActual El cuarto en el que se encuentra el NPC.
     */
    public NPC(String nombre, Cuarto cuartoActual) {
        this.nombre = nombre;
        this.cuartoActual = cuartoActual;
        this.dialogos = new HashMap<>();
    }
    
    /**
     * Método para obtener el cuarto actual en el que se encuentra el NPC.
     *
     * @return El cuarto actual del NPC.
     */
    public Cuarto getCuartoActual(){
        return this.cuartoActual;
    }
    
    /**
     * Método para agregar un diálogo al NPC.
     *
     * @param trigger   El gatillo que activa el diálogo.
     * @param respuesta La respuesta del NPC al gatillo.
     */
    public void agregarDialogo(String trigger, String respuesta) {
        dialogos.put(trigger, respuesta);
    }

    /**
     * Método para obtener la respuesta del NPC dado un gatillo (trigger).
     *
     * @param trigger El gatillo que activa el diálogo.
     * @return La respuesta del NPC al gatillo especificado.
     */
    public String obtenerRespuesta(String trigger) {
        return dialogos.get(trigger);
    }

    
    /**
     * Método para obtener el nombre del NPC.
     *
     * @return El nombre del NPC.
     */
    public String getNombre() {
        return nombre;
    }
}
