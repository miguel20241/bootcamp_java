package Java.sheet02.POO_01;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Miguel", 45);
        persona.mostrarDetalles();
        
        persona.setName("Carlos");
        persona.setEdad(30);      
        
        persona.mostrarDetalles();

        Estudiante estudiante = new Estudiante("Ana", 20, "Ingeniería");
        estudiante.mostrarDetalles();
    }
}
