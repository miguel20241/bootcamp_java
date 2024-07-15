package Java.sheet02.POO_01;

public class Empleado extends Persona implements Imprimible{

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

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();

        System.out.println(this.getSalario());
    }

    public void imprimir() {
        System.out.println("Imprimiendo detalles del empleado:");
        mostrarDetalles();
    }
}
