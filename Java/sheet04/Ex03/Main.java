package Java.sheet04.Ex03;

import static Java.sheet04.Ex03.Empleados.Departamento.*;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Mi_empresa", "23435465V");
        Empleados empleado = new Empleados(
                "78787878F",
                "Miguel",
                45,
                INFORMATICA,
                true,
                empresa,
                1600);

        System.out.println(empleado);
        double sueldo = empleado.calcularSueldo();
        System.out.println(sueldo);

        System.out.println(empleado.equals(empleado));
    }
}
