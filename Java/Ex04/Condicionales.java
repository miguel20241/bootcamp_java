package Java.Ex04;
import java.util.Scanner;

public class Condicionales {
    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);

        System.out.println("Introduzca un número entero:");
        
        if (scanObj.hasNextInt()) {
            int num = scanObj.nextInt();

            if (num > 0) {
                System.out.println("El número es positivo");
            } else if (num < 0) {
                System.out.println("El número es negativo");
            } else {
                System.out.println("El número es 0");
            }
        } else {
            System.out.println("No ha introducido un número entero");
        }     
        
        scanObj.close();
    }
}
