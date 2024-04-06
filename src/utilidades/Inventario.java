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
import java.util.*;

/**
 * La clase Inventario representa un inventario que contiene una colección de ítems.
 * Cada ítem tiene un nombre y un tamaño, y el inventario tiene una capacidad máxima
 * para almacenar ítems. Los ítems se pueden agregar, dejar y remover del inventario,
 * y se puede verificar si un ítem está presente en el inventario.
 */
public class Inventario {
    private Map<String, Item> items;
    private int capacidad ;
    private int capacidadTotal;
    /**
     * Constructo de la clase
     */
    public Inventario(int capacidad) {
        this.capacidad = capacidad;
        items = new HashMap<>();
        capacidadTotal = 0;
    }
    /**
     * 
     * @return
     */
    public Map getItem(){
       return this.items;
    }
    
     
    /**
     * Agrega un item al inventario
     * @param item
     */
    public void agregarItem(Item item) {
        if (capacidadTotal + item.getTamnho() <= capacidad) {
            items.put(item.getNombre(), item);
            capacidadTotal += item.getTamnho();
            int espacioRestante = capacidad - capacidadTotal;
            System.out.println("Ítem agregado al inventario. Espacio restante: " + espacioRestante);
        } else {
            System.out.println("El inventario está lleno. No se puede agregar más ítems.");
        }
    }
    
    /**
     *  mismo que agregarItem solo que sin mensajes de que se agrego un item
     *  al inventario
     * @param item
     */
    public void agregarItemCuartos(Item item) {
        if (capacidadTotal + item.getTamnho() <= capacidad) {
            items.put(item.getNombre(), item);
            capacidadTotal += item.getTamnho();
        } else {
            System.out.println("El inventario está lleno. No se puede agregar más ítems.");
        }
    }
    
    /**
     * Remuve un item del inventario
     * @param nombreItem El nombre del ítem a dejar en el inventario.
     */
    public void dejarItem(String nombreItem) {
        Item item = items.get(nombreItem);
        if (item != null) {
            items.remove(nombreItem);
            capacidadTotal -= item.getTamnho(); // Restar el tamaño del ítem dejado
            System.out.println("Ítem '" + nombreItem + "' dejado en el cuarto.");
        } else {
            System.out.println("El ítem '" + nombreItem + "' no está en el inventario.");
        }
    }
    
    /** 
    * Remuve un item del inventario sin mostrar menjase
    * exclusivo para uso en cuartos
    * @param nombreItem El nombre del ítem a dejar en el inventario.
    */
    public void dejarItemCuarto(String nombreItem) {
        Item item = items.get(nombreItem);
        if (item != null) {
            items.remove(nombreItem);
            capacidadTotal -= item.getTamnho(); // Restar el tamaño del ítem dejado
        } else {
            System.out.println("El ítem '" + nombreItem + "' no está en el inventario.");
        }
    }
        
    /**
     * Verificar si un item está en el inventario
     * @param nombreItem El nombre del ítem a verificar.
     * @return true si el ítem está en el inventario, false en caso contrario.
     */
    public boolean contieneItem(String nombreItem) {
        return items.containsKey(nombreItem);
    }
 
    /**
     * Obtiene un item del inventario por su nombre
     * @param nombreItem El nombre del ítem a obtener.
     * @return El ítem correspondiente al nombre especificado, o null si no se encuentra.
     */
    public Item obtenerItem(String nombreItem) {
        return items.get(nombreItem);
    }
 
    /**
     * Obtener una lista de todos los items en el inventario
     * @return Una lista de todos los ítems en el inventario.
     */
    public List<Item> obtenerTodosLosItems() {
        return new ArrayList<>(items.values());
    }
    
    /**
     * Obtiene la capacidad máxima del inventario.
     *
     * @return La capacidad máxima del inventario.
     */
    public int getCapacidad() {
        return capacidad;
    }
}



