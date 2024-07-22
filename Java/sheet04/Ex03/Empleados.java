package Java.sheet04.Ex03;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Empleados {

    enum Departamento {CONTABILIDAD, INFORMATICA, DIRECCION};

    private String dni;
    private String nombre;
    private int edad;
    private Departamento departamento;
    private boolean teletrabajo;
    private Empresa empresa;
    private double salarioBase = 1500;

    public Empleados() {
    }

    public Empleados(String dni, String nombre, int edad, Departamento departamento, boolean teletrabajo, Empresa empresa, double salarioBase) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.departamento = Departamento.valueOf(String.valueOf(departamento));
        this.teletrabajo = teletrabajo;
        setEmpresa(empresa);
        this.salarioBase = salarioBase;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        System.out.print("Introduce un DNI correcto: ");
        Matcher mat = patron.matcher(dni);
        if (mat.matches()) {
            this.dni = dni;
        } else {
            System.out.println("El dni no es válido.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = Departamento.valueOf(departamento);
    }

    public boolean isTeletrabajo() {
        return teletrabajo;
    }

    public void setTeletrabajo(boolean teletrabajo) {
        this.teletrabajo = teletrabajo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        if (empresa.getName() != null) {
            this.empresa = empresa;
        } else {
            throw new RuntimeException("Debe introducir una empresa.");
            //System.out.println("Debe introducir una empresa.");
        }
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleados empleados = (Empleados) o;
        return Objects.equals(getDni(), empleados.getDni());
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", departamento=" + departamento +
                ", teletrabajo=" + teletrabajo +
                ", empresa=" + empresa +
                ", salarioBase=" + salarioBase +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDni());
    }

    public double calcularSueldo() {
        double sueldo = getSalarioBase();
        if (getEdad() >= 30) {
            sueldo += 200;
        }

        switch (getDepartamento()) {
            case DIRECCION:
                sueldo += 100;
                break;
            case CONTABILIDAD:
                sueldo += 50;
                break;
            case INFORMATICA:
                sueldo += 80;
                break;
        }

        if (isTeletrabajo()) {
            sueldo += 30;
        }

        return sueldo;
    }
}
