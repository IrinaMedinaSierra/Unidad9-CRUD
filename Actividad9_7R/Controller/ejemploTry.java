package Actividad9_7R.Controller;

import java.util.Scanner;

public class ejemploTry {
    public static void main(String[] args) {
        Scanner sn=new Scanner(System.in);
        int opcion=0;
        do {
            mostrar("C R U D   DE   SOCIOS");
            mostrar("*************************");
            mostrar("1. Alta de Socio");
            mostrar("2. Listar Socios Ordenado por Id");
            mostrar("3. Actualizar Socio por Id");
            mostrar("4. Eliminar Socio por Id");
            mostrar("5. Salir");




    }while (opcion!=5);


    }
    public static void mostrar(String texto){
        System.out.println("\t"+texto);

    }
}
