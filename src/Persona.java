import java.time.LocalDate;
import java.util.Objects;

public class Persona implements Comparable<Persona> {

    private static final int IGUALES  = 0;
    private static final int THIS_MAYOR  = 1;
    private static final int THIS_MENOR  = -1;


    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int compareTo(Persona obj){
        if (obj == null || !(obj instanceof Persona)){
            return THIS_MAYOR;
        }

        Persona otra = (Persona) obj;
        int compAp = apellidos.compareTo(otra.apellidos);
        if (compAp != IGUALES){
            return compAp;
        }

        int compNom = nombre.compareTo(otra.nombre);
        if (compNom != IGUALES){
            return compNom;
        }

        int compEdad = fechaNacimiento.compareTo(otra.fechaNacimiento);
        return -compEdad; // consideramos menor al de mayor fecha
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(apellidos, persona.apellidos) && Objects.equals(fechaNacimiento, persona.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
