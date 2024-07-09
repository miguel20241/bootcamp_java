package Java.Ex08;

import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        
        boolean isPalindrome = true;
        Scanner scanObj = new Scanner(System.in);

        System.out.println("Introduzca un texto:");
        String text = scanObj.nextLine();

        if (!text.isEmpty()) {
            // Curiosa utilización de un bucle for
            for(int i = 0, j = text.length() - 1; i <= j; i++, j--){
                if (text.charAt(i) != text.charAt(j)) {
                    isPalindrome = false;
                    break;
                }
            }

            System.out.println("La palabra " + text + (isPalindrome ? " es": " no es") + " un palíndromo");
        } else {
            System.out.println("No es una cadena válida");
        }
        
        scanObj.close();
    }

    /* public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);

        System.out.println("Introduzca un texto:");

        if (scanObj.hasNextLine()) {
            String text = scanObj.nextLine();
            String reverseText = "";
            for (int i = text.length() - 1; i >= 0; i--) {
                reverseText += text.charAt(i);
            }
            
            System.out.println("La palabra " + text + (reverseText.equals(text) ? " es": " no es") + " un palíndromo");
        } else {
            System.out.println("No es una cadena válida");
        }

        scanObj.close();
    } */
}
