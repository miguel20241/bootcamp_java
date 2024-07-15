package Java.sheet02.POO_01;

public class Estudiante extends Persona{

    private String grado;

    public Estudiante(String name, int edad, String grado) {
        super(name, edad);
        this.grado = grado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public void mostrarDetalles(Estudiante estudiante) {
        System.out.println(estudiante.getName());
        System.out.println(estudiante.getEdad());
        System.out.println(estudiante.getGrado());
    }
    
}
