package Java.Ex07;

public class Funciones {
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;

        if (args.length == 2) {
            if (checkNum(args[0]))
                num1 = Integer.parseInt(args[0]);
            if (checkNum(args[1]))
                num2 = Integer.parseInt(args[1]);
            System.out.println("La suma es: " + suma(num1, num2));
        } else {
            System.out.println("Número de argumentos no válido! Por favor, introduce dos argumentos");
        }
        
    }

    public static int suma(int num1, int num2) {
        return num1 + num2;
    }

    public static boolean checkNum(String num) {
        if (!num.matches("[+-]?\\d+")) {
            System.out.println("El parámetro " + num + " no es entero. Lo consideraré 0.");
            return false;
        }
        return true;
    }
}
