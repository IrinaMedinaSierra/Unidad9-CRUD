package Actividad9_7R.Controller;

import Actividad9_7R.Modell.Socio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sn=new Scanner(System.in);
    //Voy a crear socios en alta, y lo agrego a esta lista...
    static ArrayList<Socio> lista=new ArrayList<>();

    public static void main(String[] args) {
        /***
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

    public static void menu(){
        int opcion;
        do {
            mostrar("C R U D   DE   SOCIOS");
            mostrar("*************************");
            mostrar("1. Alta de Socio");
            mostrar("2. Listar Socios");
            mostrar("3. Actualizar Socio por Id");
            mostrar("4. Eliminar Socio por Id");
            mostrar("5. Salir");
            mostrarSln("Indique su opción-> ");
            opcion=sn.nextInt();
        switch (opcion){
            case 1-> {
                int idT=leerID();
                mostrarSln("Nombre ->");
                String nomT=sn.next();sn.nextLine();
                mostrarSln("Fecha de Nacimiento (AAAA-MM-DD");
                String fnT= sn.next();sn.nextLine();
                Socio socio1=new Socio(idT,nomT,fnT);
                lista.add(socio1);
                menu();
            }
            case 2->{
                for (Socio e:lista){
                    mostrar(e.toString()+"\n");
                }
                menu();
            }

        }

        }while (opcion!=5);

    }
    public static void mostrar(String texto ) {
        System.out.println("\t" + texto);
    }
    public static void mostrarSln(String texto ) {
        System.out.print("\t" + texto);
    }

    public static int leerID(){
        int idLeido;
        mostrarSln("Indique el Id del Socio->");
        idLeido=sn.nextInt();
        return idLeido;
    }
}
