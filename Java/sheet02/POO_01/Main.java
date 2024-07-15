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

        Empleado empleado = new Empleado("Luis", 30, 50000f);
        empleado.mostrarDetalles();

        // Ejemplo de polimorfismo
        System.out.println("Empieza el array:");
        Persona[] personas = {
            new Estudiante("Ana", 20, "Ingeniería"),
            new Empleado("Luis", 30, 50000),
            new Persona("Marta", 40)
        };

        for (Persona person : personas) {
            person.mostrarDetalles();
        }
        // Fin ejemplo de polimorfismo
    }
}
