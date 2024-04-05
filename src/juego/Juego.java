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
import java.util.Set;

import comandos.Comando;
import utilidades.Cuarto;
import utilidades.Item;
import utilidades.Jugador;
import utilidades.Mapa;
import utilidades.Monstruo;
import utilidades.Parser;
import utilidades.Salidas;

/**
 * Esta clase es la principal para la aplicacion "Zork". Zork es un juego de
 * aventuras, simple, y basado en texto.
 *
 * En esta version, los usuarios pueden caminar através de algunos cuartos.
 * Eso es todo. Realmente el juego deberia ser extendido para volverse mas interesante.
 *
 * Para jugarlo, se debe crear una instancia de esta clase y llamar el metodo
 * "jugar"
 *
 * Esta clase crea inicializa a todas las otras, aqui empieza todo: crea todos
 * los Cuartos, crea los parsers (objetos que interpretan texto) y comienza el
 * juego. Tambien evalua los comandos que devuelve el parser.
 */

public class Juego {
    private Parser parser;
    private Cuarto cuartoActual;
    private Cuarto cuartoAnterior;
    private Jugador jugador;
    private Monstruo monstruo;
    private Cuarto cuartoMonstruo;
    /**
     * Crea el juego e inicializa su mapa interno
     */
    public Juego() {
        crearCuartos();
        this.CUARTOS_RECORRIDOS = new ArrayList();
        jugador = new Jugador("Joe", cuartoActual);
        monstruo = new Monstruo("Scp 288", cuartoMonstruo);
        jugador.getCuartoActual();
        parser = new Parser();
    }
    // Inicializacion de items individuales
    Mapa mapa1 = new Mapa("Mapa", "Pedazo de un mapa 3");
    Mapa mapa2 = new Mapa("Mapa2", "Pedazo de un mapa4");
    Mapa mapa3 = new Mapa("Mapa3", "4Pedazo de un mapa");
    Mapa mapa4 = new Mapa("Mapa4", "7Pedazo de un mapa");
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
        //
        
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
            mismo = cuartoActual.estanEnMismoCuarto(jugador, monstruo);
            totalMapas = jugador.tieneMapasSuficientes(4);
            if(mismo == false) {
                monstruo.moverMonstruo(cuartoActual);
            }
        }
        if(totalMapas == true){
            System.out.println("Haz logrado escapar de los backrooms");
        }
        if (mismo == true){
        System.out.println("Te ha deborado el " + monstruo.getNombre());
        }
        if (continuar == false){
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
     * Intenta ir en una direccion. Si esta fue una salida, entra a otra
     * habitacion, en caso contrario imprime un mensaje de error.
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
     * Mueve al jugador al cuarto anterior he imprime la descripcion del cuarto en cuestion
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
    public String mirar(){
        return cuartoActual.descripcionLarga();
    }

    /**
     *  Este metodo guarda un item en el inventario del jugador y
     *  elimina ese item del inventario del cuarto
     * @param item nombre del item a guardar 
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
        Item itemJugador = jugador.obtenerItemDelInventario(item);
        cuartoActual.agregarItemAlInventario(itemJugador);
        jugador.removerItemDelInventario(item);
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
  private final ArrayList CUARTOS_RECORRIDOS;
}
