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
import java.util.List;
import java.util.Map;

/**
 * La clase Jugador representa al usuario del juego. Tiene un nombre, un inventario
 * donde guarda los objetos que va recogiendo durante el juego, y se encuentra en
 * un cuarto específico en cada momento.
 */
public class Jugador {
    private Inventario inventario;
    private Cuarto cuartoActual;
    private String nombre = "";
    
    /**
     * Constructor de la clase Jugador.
     *
     * @param nombre       El nombre del jugador.
     * @param cuartoActual El cuarto en el que se encuentra el jugador al inicio del juego.
     */
    public Jugador(String nombre, Cuarto cuartoActual) {
        this.nombre = nombre;
        this.cuartoActual = cuartoActual;
        this.inventario = new Inventario(15);
    }
    
    /**
     * Devuelve el cuarto actual en el que se encuentra el jugador.
     *
     * @return El cuarto actual del jugador.
     */
    public Cuarto getCuartoActual(){
        return this.cuartoActual;
    }
    
    // Métodos para interactuar con el inventario del jugador

    /**
     * Agrega un ítem al inventario del jugador.
     *
     * @param item El ítem que se va a agregar al inventario.
     */
    public void agregarItemAlInventario(Item item) {
        inventario.agregarItem(item);
    }

    /**
     * Remueve un ítem del inventario del jugador.
     *
     * @param itemNombre El nombre del ítem que se va a remover del inventario.
     */
    public void removerItemDelInventario(String itemNombre) {
        inventario.dejarItem(itemNombre);
    }

    /**
     * Verifica si un ítem está en el inventario del jugador.
     *
     * @param itemNombre El nombre del ítem que se va a buscar en el inventario.
     * @return true si el ítem está en el inventario, false de lo contrario.
     */
    public boolean contieneItemEnInventario(String itemNombre) {
        return inventario.contieneItem(itemNombre);
    }

    /**
     * Obtiene un ítem del inventario del jugador por su nombre.
     *
     * @param nombreItem El nombre del ítem que se va a obtener del inventario.
     * @return El ítem obtenido del inventario.
     */
    public Item obtenerItemDelInventario(String nombreItem) {
        return inventario.obtenerItem(nombreItem);
    }

    /**
     * Obtiene una lista de todos los ítems en el inventario del jugador.
     *
     * @return Una lista de todos los ítems en el inventario del jugador.
     */
    public List<Item> obtenerTodosLosItemsDelInventario() {
        return inventario.obtenerTodosLosItems();
    }
    
    /**
     * Obtiene el inventario del jugador.
     *
     * @return El inventario del jugador.
     */
    public Map getInventario(){
        return this.inventario.getItem();
    }
    
    // Métodos para interacción con ítems en cuartos

    /**
     * Quita un ítem del inventario de un cuarto y lo agrega al inventario del jugador.
     *
     * @param cuarto El cuarto del que se va a quitar el ítem.
     * @param item   El ítem que se va a quitar del cuarto y agregar al inventario del jugador.
     */
    public void quitarItemDeCuarto(Cuarto cuarto, Item item) {
        String nombreItem = item.getNombre();
        cuarto.removerItemDelInventario(nombreItem);
        inventario.agregarItem(item);
    }

    /**
     * Guarda un ítem del inventario del jugador en el inventario de un cuarto.
     *
     * @param cuarto El cuarto en el que se va a guardar el ítem.
     * @param item   El ítem que se va a guardar en el cuarto.
     */
    public void guardarItemEnCuarto(Cuarto cuarto, Item item) {
        String nombreItem = item.getNombre();
        inventario.dejarItem(nombreItem);
        cuarto.agregarItemAlInventario(item);
    }
    
    /**
     * Verifica si el inventario del jugador contiene al menos la cantidad especificada de mapas.
     * @param cantidad la cantidad mínima de mapas que se deben encontrar en el inventario del jugador
     * @return true si el inventario contiene al menos la cantidad especificada de mapas, false de lo contrario
     */
    public boolean tieneMapasSuficientes(int cantidad) {
        int cantidadMapas = 0;
        for (Item item : inventario.obtenerTodosLosItems()) {
            if (item instanceof Mapa) {
                cantidadMapas++;
            }
        }
        return cantidadMapas >= cantidad;
    }
    
}
