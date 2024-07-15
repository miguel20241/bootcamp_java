package Java.sheet02.POO_01;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Persona persona = new Persona("Miguel", 45);
        main.mostrarDetalles(persona);
        
        persona.setName("Carlos");
        persona.setEdad(30);      
        main.mostrarDetalles(persona);
    }

    public void mostrarDetalles(Persona persona) {
        System.out.println(persona.getName());
        System.out.println(persona.getEdad());
    }
}
