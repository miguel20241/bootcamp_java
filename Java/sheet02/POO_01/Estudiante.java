package Java.sheet02.POO_01;

public class Estudiante extends Persona implements Imprimible{

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

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();

        System.out.println(this.getGrado());
    }
    
    public void imprimir() {
        System.out.println("Imprimiendo detalles del estudiante:");
        mostrarDetalles();
    }
}
