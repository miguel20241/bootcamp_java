package Java.Ex07;

public class Funciones {
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 89;

        int sum = suma(num1, num2);
        System.out.println("La suma es: " + sum);
    }

    public static int suma(int num1, int num2) {
        return num1 + num2;
    }
}
