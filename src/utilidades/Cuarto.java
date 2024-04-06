package utilidades;
/*
 * Universidad Nacional de Itapua.
 * Proyecto Zork.
 *
 * Autor Original: Michael Kolling, Universidad de Monash
 * Version: 1.1
 * Date: March 2000
 * Copyright (c) Michael Kolling
 *
 * Nombre del Alumno: Josue Amin Vera Florentin
 *
 */

import java.util.*;

/**
 *
 * Un cuarto representa una ubicacion en el escenario del juego. Aunque se llama
 * "cuarto", puede representar una ubicacion que esta adentro o afuera.
 *
 * Los cuartos estan intercontectados por medio de salidas. Hay cuartro posibles
 * salidas (por el momento) para un cuarto: norte, este, sur, oeste.
 *
 * Para cada direccion, el cuarto almacena una referencia a su habitacion vecina,
 * o null si no puede salir en esa direccion.
 *
 */

public class Cuarto {

    /**
     * Crea una habitacion descrita como "descripcion". Inicialmente, esta no
     * existe. "descripcion" es alguna cosa como "una cocina" o "la sala de
     * descanso"
     * @param descripcion
     */
    public Cuarto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        salidas = new HashMap<Object, Cuarto>();
        cuartoActual = this;
        inventario = new Inventario(50);
        npcs = new HashMap<>();
    }
    /**
     *  Setea las salidas para un cuarto
     * @param salidas 
     */
    public void setSalidas(Set<Salidas> salidas) {
        for (Salidas salida : salidas) {
            this.salidas.put(salida.getDireccion(), salida.getCuarto());
        }
    }
    /**
     *  Este metodo retorna el nombre del cuarto
     * @return Nombre del cuarto
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Retorna la descripcion de la habitacion.
     * 
     */
    public String descripcionCorta() {
        return descripcion;
    }
    
    /**
     * Retorna una descripcion extensa de esta habitacion, en la forma: Tu estas en
     * nombre de la habitacion: descripcion de la misma \n
     * Items en este cuarto \n
     * Items del cuarto.
     * 
     * @return 
     */
    public String descripcionLarga() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tu estas en ").append(nombre).append(". ").append(descripcion).append(".\n");

        // Verificar si hay items en el inventario del cuarto
        if (!this.obtenerTodosLosItemsDelInventario().isEmpty()) {
            sb.append("Items en este cuarto:\n");
            for (Object obj : this.obtenerTodosLosItemsDelInventario()) {
                Item item = (Item) obj;
                sb.append("- ").append(item.getNombre()).append(": ").append(item.getDescripcion()).append("\n");
            }
        } else {
            sb.append("No hay items en este cuarto.\n");
        }

        return sb.toString();
    }

    /**
     * Retorna todas las posibles salidas de un cuarto.
     * "Exits: north west".
     */
    @SuppressWarnings("rawtypes")
    private String textoSalidas() {
        String resultado = "Salidas:";
        Set keys = salidas.keySet();
        for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
            resultado += " " + iter.next();
        }
        return resultado;
    }

    /**
     * Metodo que regresa el cuarto siguiente al actual
     * @param direccion
     * @return Cuarto siguiente
     */
    public Cuarto siguienteCuarto(Object direccion) {
        Cuarto siguiente = salidas.get(direccion);
        cuartoActual = siguiente;
        return siguiente;
        
    }
    
    
    
    /**
     * Agregar un item al inventario del cuarto
     * @param item
     */
     public void agregarItemAlInventario(Item item) {
        inventario.agregarItemCuartos(item);
    }

    
    /**
     * Remuever un item del inventario del cuarto
     * @param nombreItem
     */
    public void removerItemDelInventario(String nombreItem) {
        inventario.dejarItem(nombreItem);
    }

     
    /**
     * Verificar si un item está en el inventario del cuarto
     * @param nombreItem
     * @return
     */
    public boolean contieneItemEnInventario(String nombreItem) {
        return inventario.contieneItem(nombreItem);
    }

    
    /**
     * Obtener un item del inventario del cuarto por su nombre
     * @param nombreItem
     * @return
     */
    public Item obtenerItemDelInventario(String nombreItem) {
        return inventario.obtenerItem(nombreItem);
    }
    
    
    /**
     * Devuelve una lista de todos los items en el inventario del cuarto
     * @return lista de Items
     */
    public List<Item> obtenerTodosLosItemsDelInventario() {
        return inventario.obtenerTodosLosItems();
    }
    /**
     * Retorna una HashMap con todad las salidad de un cuarto
     * @return HashMap salidas
     */
    public HashMap<Object, Cuarto> getHashSalidas() {
        return salidas;
    }
 
    /**
     * Agregar un NPC al cuarto
     * @param npc
     */
    public void agregarNPC(NPC npc) {
        npcs.put(npc.getNombre(), npc);
    }

     
    /**
     * Obtener un NPC del cuarto por su nombre
     * @param nombreNPC
     * @return NPC
     */
    public NPC obtenerNPC(String nombreNPC) {
        return npcs.get(nombreNPC);
    }
    
    /**
     * Elimina un NPC del cuarto
     * @param nombreNPC
     */
    public void eliminarNPC(String nombreNPC) {
        npcs.remove(nombreNPC);
    }
    
    /**
     *  Devuelve true en caso que el jugador este en el mismo cuarto que un NPC en caso contrario dara false
     * @param jugador
     * @param npc
     * @return boolean
     */
    public boolean estanEnMismoCuarto(Cuarto jugador, NPC npc) {
        Cuarto n = npc.getCuartoActual();
        if(jugador != null && npc != null ){
            if (jugador == n) {
                return true;
            }
            
        }
        if (jugador == null || npc == null) {
            System.out.println("uno de los dos es null");
        }
        return false;
    }
    
    
    
    
    private HashMap<String, NPC> npcs ;
    
    private Cuarto cuartoActual;
    // la descripcion del cuarto
    private String descripcion;
    // contiene la lista de salidas para este cuarto
    private HashMap<Object, Cuarto> salidas;
    // inventaio del cuartp    
    private Inventario inventario;
    // nombre del cuato
    private final String nombre; 
    // direcciones de salidas
    public static final Object NORTE = "norte";
    public static final Object ESTE = "este";
    public static final Object SUR = "sur";
    public static final Object OESTE = "oeste";
    

}