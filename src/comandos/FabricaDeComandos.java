package comandos;
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
 * Esta clase puede construir cualquier comando entendido en el juego.
 *
 * Basicamente establece una relacion entre lo que ingresa el usuario
 * en el teclado y el objeto que ejecuta el comando.
 *
 * La implementacion que utilizamos aqui es muy simple, basicamente
 * utiliza un Map para hacerlo altamente mantenible.
 *
 */

public class FabricaDeComandos {

    /**
     * Constructor - inicializa los comandos.
     */
    @SuppressWarnings("unchecked")
    public FabricaDeComandos() {
        // Para agregar un comando nuevo
        // tienes que:
        //
        // 1. Crear una nueva clase de comando
        // 2. Crear una nueva constante en esta clase que indica
        //    el nombre del comando que va a usar el usuario
        // 3. No olvidarte de incluirlo en el mapa comandosConocidos
        //
        this.comandosConocidos.put(DIALOGOS, new ComandoHablar());
        this.comandosConocidos.put(DEJAR, new ComandoDejar());
        this.comandosConocidos.put(GUARDAR, new ComamdoAgregar());
        this.comandosConocidos.put(INVENTARIO, new ComandoInventario());
        this.comandosConocidos.put(MIRAR, new ComandoMirar());
        this.comandosConocidos.put(ATRAS, new ComandoAtras());
        this.comandosConocidos.put(IR, new ComandoIr());
        this.comandosConocidos.put(AYUDA, new ComandoAyuda());
        this.comandosConocidos.put(SALIR, new ComandoSalir());
        this.comandosConocidos.put(INICIO,new ComandoInicio());
    }

    /**
     * Crea un comando en base a dos palabras. La primera palabra es para
     * indicar que comando usar, la segunda como dato adicional.
     *
     * Por ejemplo si las palabras son "ir" y "norte", va a buscar un comando
     * para "ir" y le va a dar el dato adicional que es "norte".
     *
     * @param palabraComando la palabra que representa el comando
     * @param palabraAdicional dato adicional que necesita tu comando
     * @return el comando creado
     */
    public Comando crearComando(String palabraComando, String palabraAdicional, String palabraAdicional2, String palabraAdicional3) {

        Comando comando = (Comando)this.comandosConocidos.get(palabraComando);

        if (null == comando) {
            comando = new ComandoDesconocido();
        } else {
            // no queremos modificar nuestra version original
            // hacemos una copia para que no afecte en el futuro
            comando = comando.copiar();
        }

        // le decimos que palabras utilizamos para este comando
        comando.setPalabras(Arrays.asList(new String[] {palabraComando, palabraAdicional,palabraAdicional2,palabraAdicional3}));
        return comando;

    }

    /**
     * Crea un comando de tipo ComandoDesconocido
     *
     * @return un comando de tipo ComandoDesconocido
     */
    public Comando crearComandoDesconocido() {
        return new ComandoDesconocido();
    }

    /**
     * Devuelve una colleccion que contiene los nombres de los
     * comandos conocidos.
     *
     * @return un objeto de tipo List que con la lista
     *  de nombres de comandos conocidos
     */
    @SuppressWarnings("rawtypes")
    public Collection comandosConocidos() {
        return this.comandosConocidos.keySet();
    }

    // no te olvides de incluir esto en la lista de
    // comandos conocidos
    private static final String DIALOGOS = "hablar";
    private static final String DEJAR = "dejar";
    private static final String GUARDAR = "guardar";
    private static final String INVENTARIO = "inventario";
    private static final String MIRAR = "mirar";
    private static final String ATRAS = "atras";
    private static final String IR = "ir";
    private static final String SALIR = "salir";
    private static final String AYUDA = "ayuda";
    private static final String INICIO = "inicio";

    // aqui pondremos los comandos que conocemos
    @SuppressWarnings("rawtypes")
    private final Map comandosConocidos = new HashMap();
}
