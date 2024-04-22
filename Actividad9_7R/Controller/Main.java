package Actividad9_7R.Controller;

import Actividad9_7R.Modell.Socio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class Main {
    static Scanner sn=new Scanner(System.in);
    //Voy a crear socios en alta, y lo agrego a esta lista...
    static ArrayList<Socio> lista=new ArrayList<>();

    public static void main(String[] args) {
        /*
         * Crear un menu, insertar los datos, despues guardarlos....ArrayList->Colección
         *          C R U D        CREAR - LEER - ACTUALIZAR -BORRAR
         *          R E P E
         *          E A D L
         *          A D A E
         *          T   T T
         *          E   E E
         *
         */
    menu();
    }

    /**
     *Menú de opciones y envia a los respectivos métodos para validar y realizar las acciones seleccionadas
     */
    public static void menu(){
        int opcion;
        do {
            mostrar("C R U D   DE   SOCIOS");
            mostrar("*************************");
            mostrar("1. Alta de Socio");
            mostrar("2. Listar Socios Ordenado por Id");
            mostrar("3. Actualizar Socio por Id");
            mostrar("4. Eliminar Socio por Id");
            mostrar("5. Salir");

            mostrarSln("Indique su opción-> ");
            opcion=sn.nextInt();




        switch (opcion) {
            case 1 -> {
                int idT=idExiste(leerID());
                lista.add(leerDatos(idT));

            }
            case 2 ->
                listar();

            case 3 -> {
                int idA = leerID();
                //verificamos que el id existe buscando la posicion en la lista
                actualizarEliminar(idA, 3);
            }
            case 4-> {
                int idA=leerID();
                actualizarEliminar(idA,4);
            }
            case 5->
                mostrar("Hasta pronto...Saliendo del Sistema......");

            default -> mostrar("Opción no válida");
        }

        }while (opcion!=5);

    }

    /**
     *Metodo para mostrar textos
     * @param texto que recibe como parametro para mostrar
     */
    public static void mostrar(String texto ) {
        System.out.println("\t" + texto);
    }

    /**
     *Metodo para mostrar textos sin salto de línea
     * @param texto que recibe como parametro para mostrar
     */
    public static void mostrarSln(String texto ) {
        System.out.print("\t" + texto);
    }

    /**
     *Método que solicita al usuario que escriba el id, y lo valida que sea numérico utilizando un try cach
     * @return devuelve el id validado que sea numerico
     */
    public static int leerID(){
        int idLeido=-1;
        do {
            try {
                mostrarSln("Indique el Id del Socio->");
                idLeido = sn.nextInt();
            } catch (InputMismatchException e) {
                mostrar("**El formato no es correcto, solo números**");
                sn.next(); // Limpiar el buffer del scanner
            }
        } while (idLeido == -1);

        return idLeido;
    }

    /**
     *Método que valida si el Id indicado existe en la lista, con el fin de que el id sean unicos y no se repitan
     * @param idT recibe el id para ser buscado, utilizando el método buscarPosicion()
     * @return el id despues de confirmar que no existe en la lista, par aque no haya repetidos
     */
    public static int idExiste(int idT){
        while (buscarPosicion(idT)>=0){
            mostrarSln("**Número de ID existe**");
            idT=leerID();
        }
        return idT;
    }

    /**
     * Método donde se solicita el nombre y fecha de nacimiento. Como estos mismos datos son necesarios para las opciones
     * de Alta y Actualización, se lee antes el ID en otro método, para ambos casos y se para en la llamada al Método.
     * Se valida si el nombre es letras llamando a la función contieneSoloLetras()
     * Se valida si la fecha es correcta, creando un LocalDate con la fecha introducida, si esta falla, quiere decir
     * que el formato introducido no es válido
     *
     * @param idT representa el id del nuevo registro o el id del registro a actualizar
     * @return un objeto tipo Socio para incluir en la lista o para reemplarlo en caso de actualización
     */
    public static Socio leerDatos(int idT){
        boolean fechaCorrecta=false;

        String fnT=null;
        mostrarSln("Nombre ->");
        String nomT = new Scanner(System.in).nextLine();
       while (!contieneSoloLetras(nomT)){
           mostrarSln("El nombre debe contener solo letras-> ");
           nomT = new Scanner(System.in).nextLine();
       }
        do {
            try {
                mostrarSln("Fecha de Nacimiento (DD-MM-AAAA) ->");
                fnT = new Scanner(System.in).nextLine();
                DateTimeFormatter f=DateTimeFormatter.ofPattern("dd-MM-yyyy");//Se crea el Formato
                LocalDate fechaNacimiento=LocalDate.parse(fnT,f);
                fechaCorrecta=true;
            } catch (DateTimeParseException e) {
                mostrar("**El formato no es correcto. Indique una fecha Válida**");
            }
        }while (!fechaCorrecta);
        return new Socio(idT,nomT,fnT);
    }

    /**
     * Método en donde se realiza las dos acciones: Actualizar O Eliminar. Requiere el id para identificar si existe,
     * y la opción para llevar a cabo la acción.
     * Se utiliza un mismo método por la similitud de su algoritmo, solo difiere en la acción final
     *
     * @param idAE Indica el Id del socio a Actualizar o Eliminar
     * @param opcion puede ser Actualizar o Eliminar
     */
    public static void actualizarEliminar(int idAE,int opcion){
        int posicion = buscarPosicion(idAE); //si posicion es -1 no existe ese id
        String accion=opcion==3?"Actualización":"Eliminación";
        if(posicion>=0 && opcion==3) { //solo se pide datos si ese id existe
            //solicitamos los datos y creamos un nuevo objeto para insertarlo
            Socio socioActualizar=leerDatos(idAE);
            mostrar("Datos Actuales->" + lista.get(posicion));
            mostrar("Datos a actualizar->" + socioActualizar);
            if(confirmacion()){
                lista.set(posicion, socioActualizar);
                mensajeExito(accion);
            }else {
                mensajeExito(accion);
            }
        }
        if(posicion>=0 && opcion==4){
            if (confirmacion()) {
                lista.remove(posicion);
                mensajeExito(accion);
            }else{
                mensajeNoRealizado(accion);
            }
        }
        if(posicion<0 && opcion==3 || posicion<0  && opcion==4){
            mostrar("**El ID  Indicado no corresponde a ningún Socio**");
        }

    }

    /**
     *Método que recorre la lista y muestra en pantalla todos los Socios
     */
    public static void listar(){
        mostrar("**** Listado de Socios ****");
        mostrar("***************************");
        Collections.sort(lista);
        for (Socio e:lista){
            mostrar(e.toString()+" ");
        }
    }

    /**
     *Método que busca el ID en la lista y verifica si este existe.
     * @param id necesario para conocer si existe o no
     * @return posicion devuelve la posición, en caso de ser -1 es que no existe
     */
    public static int buscarPosicion(int id){
        int posicion=-1;
        for (Socio e:lista) {
            if (e.getId() == id) {
                posicion=lista.indexOf(e);
                break;
            }
        }
        return posicion;
    }

    /**
     *Método que pregunta al usuario si está seguro de Actualizar o Eliminar un Socio
     * @return confirmado devuelve true o false
     */
    public static boolean confirmacion(){
        boolean confirmado=false;
        mostrarSln("Esta seguro de hacer los cambios [S] o [N]->");
        String confirmar=new Scanner(System.in).next();
        if (confirmar.equalsIgnoreCase("S")) {
        confirmado=true;
        }
        return confirmado;
    }

    /**
     * Métodos para enviar el mensaje de Confirmación de la Acción seleccionada
     * @param accion que indica la opcion de Actualización Eliminación
     */
    public static void mensajeExito(String accion){
        mostrar("******************************************");
        mostrar("**"+accion+" realizada correctemente.....** ");
        mostrar("*******************************************");
    }
    public static void mensajeNoRealizado(String accion){
        mostrar("******************************************");
        mostrar("**No se ha realizado ninguna "+accion+" ** ");
        mostrar("*******************************************");
    }

    /**
     * Metodo que evalua una expresión regular para el nombre, solo letras y espacios aceptados en el String
     * @param texto del nombre leido en el Scanner
     * @return verdadero o falso según la evaluación de la Expresión Regular
     */
    public static boolean contieneSoloLetras(String texto) {
        // Expresión regular que verifica si el texto contiene solo letras (mayúsculas o minúsculas)
        return texto.matches("[a-zA-Z\\s]+");
    }
}
