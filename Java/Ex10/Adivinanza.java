package Java.Ex10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Adivinanza {
    public static void main(String[] args) {
        boolean isCorrect = false;
        int randomNum = (int) (Math.random() * 101);
        System.out.println(randomNum);
        Scanner scanObj = new Scanner(System.in);

        System.out.println("Juego adivina el número entre el 1 y el 100");
        
        while (!isCorrect) {
            System.out.println("Introduce un número");

            try {
                int num = scanObj.nextInt();
                if (num > randomNum) {
                    System.out.println("El número es menor que " + num);
                } else if (num < randomNum) {
                    System.out.println("El número es mayor que " + num);
                } else {
                    isCorrect = true;
                }   
             
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                scanObj.next();
            }
        }
        
        System.out.println("Ha acertado!!. El número era: " + randomNum);
        scanObj.close();
    }
}
