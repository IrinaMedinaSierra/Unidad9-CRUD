package Actividad9_7R.Modell;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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

        this.fechaNacimiento=LocalDate.parse(fechaNacimiento); // se convierte un String en LocalDate


    }

    /**
     * Método para calcular a partir de la fecha de nacimiento, la edad de un socio.
     * Se utiliza "until" que significa una resta entre las dos fechas, fecha actual - fecha de nacimiento.
     * @return
     */
    public int edad(){
        return (int) this.fechaNacimiento.until(LocalDate.now(),ChronoUnit.YEARS);
    }

    public int compareTo(Object oj){
        int resultado;
        //hacer un casting del tipo objeto a tipo Socio
        Socio s=(Socio) oj;
        if (this.id<s.id){
            resultado =-1;
        }else if (this.id>s.id){
            resultado=1;
        }else {
            resultado=0;
        }
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

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
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
