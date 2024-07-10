package Java.Ex07;

public class Funciones {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        
        System.out.println("La suma es: " + suma(num1, num2));
    }

    public static int suma(int num1, int num2) {
        return num1 + num2;
    }
}
