package Actividad9_7R.Controller;

import Actividad9_7R.Modell.Socio;


public class Main {
    public static void main(String[] args) {
        Socio s1=new Socio(4,"Manuel Diaz","2000-12-01");
        Socio s2=new Socio(3,"José Hernandez","1999-01-15");
        System.out.println(s1.compareTo(s2));
        System.out.println(s1);
        System.out.println(s2);

    }
}
