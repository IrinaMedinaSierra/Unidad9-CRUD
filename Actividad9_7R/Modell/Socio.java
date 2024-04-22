package Actividad9_7R.Modell;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * Implementar la interfaz Comparable en la clase Socio para que por defecto, se ordene según los números de identificación
 * Id de forma creciente.
 */

public class Socio  implements Comparable{
    private int id;
    private String nombre;
    LocalDate fechaNacimiento;

    public Socio(int id, String nombre, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        //establecer la fecha de nacimiento en formato Español
        DateTimeFormatter f=DateTimeFormatter.ofPattern("dd-MM-yyyy");//Se crea el Formato
        this.fechaNacimiento=LocalDate.parse(fechaNacimiento,f); // se convierte un String en LocalDate


    }

    /**
     * Método para calcular a partir de la fecha de nacimiento, la edad de un socio.
     * Se utiliza "until" que significa una resta entre las dos fechas, fecha actual - fecha de nacimiento.
     * @return resultado
     */
    public int edad(){
        return (int) this.fechaNacimiento.until(LocalDate.now(),ChronoUnit.YEARS);
    }

    public int compareTo(Object oj){
        int resultado;
        //hacer un casting del tipo objeto a tipo Socio
        Socio s=(Socio) oj;
        resultado = Integer.compare(this.id, s.id);
        return resultado;
    }

//    public int compareTo(Object otro){
//        int resulado;
//        Socio otroS=(Socio) otro;
//        resulado=this.nombre.compareTo(otroS.nombre);
//        return resulado;
//    }


    public int getId() {
        return id;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return id == socio.id;
    }

    @Override
    public String toString() {
        DateTimeFormatter f=DateTimeFormatter.ofPattern("dd-MM-yyyy");//Se crea el Formato
        return "Socio->" +
                "id=" + id +
                ", nombre='" + nombre  +
                ", fechaNacimiento=" + fechaNacimiento.format(f) +
                ", edad: " +edad();
    }
}
