package Java.sheet03.Ex08;

public class Main {
    public static void main(String[] args) {
        int number = 10;

        divide(number, 4);
        divide(number, 0);
        divide(number, -10);
    }

    private static void divide(int number, int divisor) {
        try {

            System.out.println("El resultado de la división de " + number + " entre " + divisor + " es " +  number / divisor);
            
        } catch (Exception e) {

            System.out.println("Error: División por 0. " + e.getMessage());

        }
    }
}
