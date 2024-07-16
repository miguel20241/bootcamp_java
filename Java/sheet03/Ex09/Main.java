package Java.sheet03.Ex09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        checkEmail("test@example.com");
        checkEmail("adiasfd.com");

    }

    private static void checkEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.find();

        if (matchFound) {
            System.out.println(email + " es un correo válido.");
        } else {
            System.out.println(email + " no es un correo válido.");
        }
    }
}