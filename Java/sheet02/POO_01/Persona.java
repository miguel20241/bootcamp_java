package Java.sheet02.POO_01;

public class Persona {
    private String name;
    private int edad;

    public Persona(String name, int edad) {
        this.name = name;
        this.edad = edad;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void mostrarDetalles(Persona persona) {
        System.out.println(persona.getName());
        System.out.println(persona.getEdad());
    }
}
