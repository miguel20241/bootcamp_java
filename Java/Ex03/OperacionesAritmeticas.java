package Java.Ex03;
import java.util.Scanner;

public class OperacionesAritmeticas {
    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);

        System.out.println("Introduzca un número:");
        Float num1 = scanObj.nextFloat();

        System.out.println("Introduzca otro número:");
        Float num2 = scanObj.nextFloat();

        System.out.println("Suma de " + num1 + " + " + num2 + " = " + (num1 + num2));
        System.out.println("Resta de " + num1 + " - " + num2 + " = " + (num1 - num2));
        System.out.println("Multiplicación de " + num1 + " * " + num2 + " = " + (num1 * num2));
        if (num2 == 0) {
            System.out.println("No se puede dividir entre 0");
        } else {
            System.out.println("División de " + num1 + " / " + num2 + " = " + (num1 / num2));
        }
    }
}
