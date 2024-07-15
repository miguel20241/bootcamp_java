package Java.sheet02.POO_01;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Miguel", 45);

        Main main = new Main();
        main.mostrarDetalles(persona);
    }

    public void mostrarDetalles(Persona persona) {
        System.out.println(persona.name);
        System.out.println(persona.edad);
    }
}
