package Actividad9_1R.Controller;

import Actividad9_1R.Modell.Cola;
import Actividad9_1R.Modell.Lista;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lista c=new Lista();
        c.encolar(1);//utilizamos la interace cola implementada en Lista
        c.encolar(2);
        c.encolar(3);
        c.encolar(4);
        c.encolar(5);
        c.encolar(6);
        c.encolar(7);
        System.out.println(c);
        c.desencolar();
        System.out.println(c.numeroElementos()); //la clase Lista
        System.out.println(c);
        Cola x = new Lista();
        System.out.print("Introducir número: ");
        Integer n = new Scanner(System.in).nextInt();
        while (n >= 0) {
            x.encolar(n);
            System.out.print("Introducir número: ");
            n = new Scanner(System.in).nextInt();
        }
        n = x.desencolar();
        System.out.println("Desencolando");
        while (n != null) { //la cola vacía devuelve null al desencolar
            System.out.print(n + " ");
            n = x.desencolar();
        }
        System.out.println("");

    }
}
