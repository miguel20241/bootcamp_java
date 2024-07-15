package Java.sheet02.POO_01;

public class Empleado extends Persona{

    private float salario;

    public Empleado(String name, int edad, float salario) {
        super(name, edad);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }  

    public void mostrarDetalles() {
        System.out.println(this.getName());
        System.out.println(this.getEdad());
        System.out.println(this.getSalario());
    }
}
