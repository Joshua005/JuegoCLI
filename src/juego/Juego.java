package juego;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import comandos.Comando;
import utilidades.Cuarto;
import utilidades.Item;
import utilidades.Jugador;
import utilidades.Mapa;
import utilidades.Monstruo;
import utilidades.NPC;
import utilidades.Parser;
import utilidades.Salidas;

/**
 * La clase Juego es la principal para la aplicación "Escape to the Backrooms". 
 * Este juego de aventuras basado en texto permite a los jugadores explorar 
 * diferentes cuartos, recolectar objetos y escapar de un monstruo.
 */

public class Juego {
    private final ArrayList CUARTOS_RECORRIDOS;
    private Parser parser;
    private Cuarto cuartoActual;
    private Cuarto cuartoAnterior;
    private Cuarto cuartoMonstruo;
    private Jugador jugador;
    private Monstruo monstruo;
    private Cuarto npcCuca;
    private NPC npc1;
    /**
     * Crea el juego e inicializa su mapa interno
     */
    public Juego() {
        crearCuartos();
        this.CUARTOS_RECORRIDOS = new ArrayList();
        npc1 = new NPC("Roier",npcCuca,"Hola, supogo encotraste mi antigua cama");
        jugador = new Jugador("Joe", cuartoActual);
        monstruo = new Monstruo("Scp 288", cuartoMonstruo);
        jugador.getCuartoActual();
        parser = new Parser();
        npc1.agregarDialogo("EH?", "Si mi vieja cama debe estar por ahí en algun lado");
    }
    // Inicializacion de items individuales
    Mapa mapa1 = new Mapa("Fragmento de Mapa ", "Un pedazo de papel con un dibujo que parece ser un pasillo sin fin. Hay algunas inscripciones en el borde");
    Mapa mapa2 = new Mapa("Fragmento de Mapa2", "Un trozo de pergamino arrugado con una serie de líneas que sugieren un laberinto. En un rincón");
    Mapa mapa3 = new Mapa("Fragmento de Mapa3", "Un mapa hecho a mano que muestra un camino borroso que conduce a una habitación desconocida.");
    Mapa mapa4 = new Mapa("Fragmento de Mapa4", "Otro trozo de papel que parece ser un mapa, sera este el ultimo?");

    Item alfombra = new Item("Alfombra", "Una alfombra vieja", 20);
    Item marmolada = new Item("Marmolada", "Nada como una buena marmolada",4); 
    
    /**
     * Crea todas las habitaciones y enlaza todas sus salidas
     */
    private void crearCuartos() {    
        // crear los cuartos
        Cuarto inicio = new Cuarto("Inicio" ,"Aqui econtraste el mapa");//1
        Cuarto alfombraCuarto = new Cuarto("Alfombra","Hay una alfombra sucia aqui");//2
        Cuarto mancha = new Cuarto("Mancha Pared","Hay una mancha grande en la pared");//3
        Cuarto pozo = new Cuarto("Pozo","Parece haber un pozo al fondo");//4
        Cuarto mapaCuarto = new Cuarto("Pedazo Mapa", "Parece ser que hay otro pedazo del mapa aqui");  //5
        Cuarto oscuro = new Cuarto("Cuarto oscuro","Este cuarto parece ser mas oscuro que los demas");//6
        Cuarto chipa = new Cuarto("Chipa?", "Pareciara haber restos de una chipa aqui");//8
        Cuarto olorRaro = new Cuarto("Olor raro", "Este cuarto huele mas peor que los anteriores"); //9
        Cuarto trampa = new Cuarto("Trampa", "Haz caido en una trampa");//10
        Cuarto sucio = new Cuarto("Cuarto sucio", "Podria ser el cuarto mas sucio que eh visto en toda mi vida"); //11
        Cuarto marmoladaCuarto = new Cuarto("Una mamorlada", "No se como llego esto aqui");//12        
        Cuarto verde = new Cuarto("Verde?", "Un cuarto verde?");//13
        Cuarto cucarachas = new Cuarto("Cucarachas", "Este cuarto esta infestado de cucarachas") ;//14
        Cuarto cuartoMapas5 = new Cuarto("Pedazo Mapa", "Parese ser que aqui habia un pedazo del mapa");//15
        Cuarto cama = new Cuarto("Cama", "No parece que nadie haya dormido aqui en un tiempo");//16
        // inicializar las salidas
        inicio.setSalidas(Set.of(new Salidas(Cuarto.SUR, oscuro),new Salidas(Cuarto.ESTE, alfombraCuarto)));
        alfombraCuarto.setSalidas(Set.of( new Salidas(Cuarto.ESTE, mancha)));
        mancha.setSalidas(Set.of(new Salidas(Cuarto.ESTE, pozo)));
        pozo.setSalidas(Set.of(new Salidas(Cuarto.ESTE, mapaCuarto)));
        mapaCuarto.setSalidas(Set.of(new Salidas(Cuarto.SUR, trampa)));
        oscuro.setSalidas(Set.of(new Salidas(Cuarto.SUR, sucio)));
        chipa.setSalidas(Set.of(new Salidas(Cuarto.ESTE, olorRaro)));
        olorRaro.setSalidas(Set.of(new Salidas(Cuarto.ESTE, trampa)));
        trampa.setSalidas(Set.of(new Salidas(Cuarto.OESTE, olorRaro), new Salidas(Cuarto.NORTE, mapaCuarto), new Salidas(Cuarto.SUR, cuartoMapas5)));
        sucio.setSalidas(Set.of(new Salidas(Cuarto.ESTE, marmoladaCuarto), new Salidas(Cuarto.SUR, cama)));
        cama.setSalidas(Set.of(new Salidas(Cuarto.NORTE, marmoladaCuarto)));
        cucarachas.setSalidas(Set.of(new Salidas(Cuarto.ESTE, cuartoMapas5)));
        marmoladaCuarto.setSalidas(Set.of(new Salidas(Cuarto.ESTE, verde)));
        verde.setSalidas(Set.of(new Salidas(Cuarto.ESTE, cucarachas),new Salidas(Cuarto.NORTE, chipa)));
        cuartoMapas5.setSalidas(Set.of(new Salidas(Cuarto.NORTE, trampa)));
        // Inicializacion de los mapas
        mapa1.agregarCuarto(inicio.getNombre(), inicio);
        mapa2.agregarCuarto(mapaCuarto.getNombre(), mapaCuarto);
        mapa3.agregarCuarto(cama.getNombre(), cama);
        
        
        // inicializar los items de cada cuarto
        inicio.agregarItemAlInventario(mapa1);
        marmoladaCuarto.agregarItemAlInventario(marmolada);
        mapaCuarto.agregarItemAlInventario(mapa2);
        cama.agregarItemAlInventario(mapa3);
        cuartoMapas5.agregarItemAlInventario(mapa4);
        alfombraCuarto.agregarItemAlInventario(alfombra);
        // empezar juego afuera
        cuartoActual = inicio;
        cuartoMonstruo = cuartoMapas5;
        npcCuca = cucarachas;
    }

    
    /**
     * Rutina principal: jugar. Itera hasta el fin del juego..
     */
    public void jugar() {
        imprimirBienvenida();
        // Jugar hasta que un comando me diga que ya no quiere jugar mas
        boolean continuar = true;
        boolean mismo = false;
        boolean totalMapas = false;
        while (continuar ==true && mismo == false && totalMapas == false ) {
            Comando comando = parser.getComando();
            continuar = comando.ejecutar(this);
            mismo = cuartoActual.estanEnMismoCuarto(cuartoActual, monstruo);
            totalMapas = jugador.tieneMapasSuficientes(4);
            if(mismo == false) {
                monstruo.moverMonstruo(cuartoActual);
            }
        }
        if(totalMapas){
            System.out.println("Haz logrado escapar de los backrooms");
        }
        if (mismo){
        System.out.println("Te ha deborado el " + monstruo.getNombre());
        }
        if (!continuar){
            System.out.println("Haz logrado escapar");
        }
    }

    /**
     * Imprime a la terminar el mensaje de bienvenida del jugador..
     */
    private void imprimirBienvenida() {
        System.out.println();
        System.out.println("Bienvenido a Escape to the Backrooms! ");
        System.out.println("Este es un juego demasiado simple de aventura: ");
        System.out.println("Escriba 'inicio' para comenzar el juego, tambien puedes escribir 'ayuda' por si la nesecitas.");
        System.out.println();
    }

    /**
     * Intenta mover al jugador en una dirección específica.
     * @param direccion La dirección en la que intenta moverse el jugador.
     */
    public void irA(String direccion) {
        if (null == direccion) {
            // si no hay direccion no sabemos a donde ir
            System.out.println("¿Ir donde?");
            return;
        }

        // Intenta salir del cuarto y guarda el cuarto anterior
        CUARTOS_RECORRIDOS.add(cuartoActual);
        Cuarto siguienteCuarto = cuartoActual.siguienteCuarto(direccion);
        CUARTOS_RECORRIDOS.add(siguienteCuarto);
        if (null == siguienteCuarto) {
            System.out.println(
                "Eeeem... no puedo ir para allí... es demasiado oscuro.");
        } else {
            cuartoActual = siguienteCuarto;
            System.out.println(cuartoActual.descripcionLarga());
        }
    }
    /**
     * Mueve al jugador al cuarto anterior e imprime la descripción del cuarto.
     */
    public void atras(){
        try{
        if(!CUARTOS_RECORRIDOS.isEmpty()){
            cuartoAnterior = (Cuarto) CUARTOS_RECORRIDOS.get(CUARTOS_RECORRIDOS.indexOf(cuartoActual)-1);
            CUARTOS_RECORRIDOS.remove(CUARTOS_RECORRIDOS.indexOf(cuartoActual));
            cuartoActual = cuartoAnterior;
            imprimir(cuartoActual.descripcionLarga());
        }
        else{
            imprimir("Estas en el inicio.");
        }
    }
    catch (IndexOutOfBoundsException e){
            imprimir("Estas en el inicio.");
        }
    }
    
    /**
     *  Retorna la descipcion del cuarto actual
     * @return la descripcion larga de el cuarto
     */
    public String mirarDescripcionCuarto(){
        return cuartoActual.descripcionLarga();
    }
    
    /**
     * Muestra el diálogo del NPC presente en el cuarto actual, si lo hay.
     */
    public void mirar(){
        if(cuartoActual.estanEnMismoCuarto( cuartoActual, npc1)){
            imprimir(npc1.getNombre()+":  " + npc1.getDialogoPorDefecto() );
        }
        else{
            imprimir("Este en este cuarto no hay nadie");
        }
        
    }

    /**
     * Retorna un conjunto de diálogos disponibles en el cuarto actual.
     * @return Un conjunto de cadenas que representan los diálogos disponibles.
     */
    public Set<String> dialogos(){
        Set<String> mens = new HashSet<>(Arrays.asList("No hay nadie aqui"));

        if(cuartoActual.estanEnMismoCuarto( cuartoActual, npc1)){
            return npc1.getPalabras();
        }
        return mens;
    }
    
    /**
     * Permite al jugador hablar con el NPC presente en el cuarto actual.
     * @param mensaje El mensaje que el jugador desea decir.
     * @return La respuesta del NPC al mensaje del jugador.
     */
    public String hablar(String mensaje ){
        String respuesta = "A quien le hablas?";
        if(cuartoActual.estanEnMismoCuarto( cuartoActual, npc1)){
            return npc1.obtenerRespuesta(mensaje);  
        }
        return respuesta;
    }
    /**
     * Guarda un item en el inventario del jugador y lo elimina del cuarto.
     * @param item El nombre del item a guardar.
     */
    public void guardarItems(String item){
        try {
            Item itemCuarto = cuartoActual.obtenerItemDelInventario(item);
            jugador.agregarItemAlInventario(itemCuarto);
            cuartoActual.removerItemDelInventario(item);
        } catch (NullPointerException e) {
            imprimir("Que quieres guardar?");
        }
    }
    
    /**
     * Suelta un item del jugador en el cuarto donde se encuentra
     * @param item nombre del item a dejar
     */
    public void dejarItems(String item){
        try{
            Item itemJugador = jugador.obtenerItemDelInventario(item);
            cuartoActual.agregarItemAlInventario(itemJugador);
            jugador.removerItemDelInventario(item);
        }catch (NullPointerException e){
            imprimir("Que quieres dejar?");
        }
    
    }
    
    /**
     * Metodo que retorna un String con todos lo items que tiene el jugador en su inventario
     * @return Un String con los items de esta manera (Tu inventario .\n Item : descripcion).
     */
    public String invetarioJugador(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tu inventario ").append(".\n");
        if (!jugador.obtenerTodosLosItemsDelInventario().isEmpty()) {
            for (Object obj : jugador.getInventario().values()) {
                Item item = (Item) obj;
                sb.append("- ").append(item.getNombre()).append(": ").append(item.getDescripcion()).append("\n");
            }
        } else {
            sb.append("No hay items.");
        }

        return sb.toString();
    }
    /**
     * Metodo para obtener especificamente los mapas del inventario del jugador
     * @param nombreItem nombre del mapa
     * @return Item tipo mapa
     */
    public Item obtenerItemMapasJugador(String nombreItem) {
        // Obtener el item del inventario del jugador por su nombre
        Item item = jugador.obtenerItemDelInventario(nombreItem);
        
        // Verificar si el item obtenido es un mapa
        if (item instanceof Mapa) {
            return item;
        } else {
            System.out.println("El item seleccionado no es un mapa.");
            return null;
        }
    }
    
    /**
     * Imprime un mensaje para el usuario
     *
     * @param mensaje
     */
    public void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Pasa a la siguiente linea.
     *
     */
    public void imprimir() {
        System.out.println();
    }

    /**
     * Imprime un mensaje para el usuario, pero
     * se queda en la misma linea.
     *
     * @param mensaje
     */
    public void imprimirCont(String mensaje) {
        System.out.print(mensaje);
    }
  
}
