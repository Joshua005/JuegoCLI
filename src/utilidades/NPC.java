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
 * 
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
     * 
     * @param nombre
     * @param cuartoActual
     */
    public NPC(String nombre, Cuarto cuartoActual) {
        this.nombre = nombre;
        this.cuartoActual = cuartoActual;
        this.dialogos = new HashMap<>();
    }
    /**
     * 
     * @return
     */
    public Cuarto getCuartoActual(){
        return this.cuartoActual;
    }
    
    // Agregar un diálogo al NPC
    /**
     * 
     * @param trigger
     * @param respuesta
     */
    public void agregarDialogo(String trigger, String respuesta) {
        dialogos.put(trigger, respuesta);
    }

    // Obtener una respuesta del NPC dado un trigger (gatillo)
    /**
     * 
     * @param trigger
     * @return
     */
    public String obtenerRespuesta(String trigger) {
        return dialogos.get(trigger);
    }

    // Obtener el nombre del NPC
    /**
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }
}
