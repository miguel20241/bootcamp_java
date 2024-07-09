package Java.Ex09;

import java.util.Scanner;

public class Saludo {
    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);

        System.out.println("Introduzca su nombre:");

        String name = scanObj.nextLine();
        System.out.println("Hola, Don " + name + "!!");
        
        scanObj.close();
    }
}
