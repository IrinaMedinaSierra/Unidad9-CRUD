package Controller;

import Modell.Cola;
import Modell.Lista;

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
    }
}
