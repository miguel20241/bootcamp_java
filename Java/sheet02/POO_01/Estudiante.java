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

    public void mostrarDetalles() {
        System.out.println(this.getName());
        System.out.println(this.getEdad());
        System.out.println(this.getGrado());
    }
    
}
