package Java.sheet03.Ex01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateExample {
    public static void main(String[] args) {
        LocalDateTime dateTimeObj = LocalDateTime.now();
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Formato 1: " + dateTimeObj.format(formatDateTime));

        formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Formato 2: " +  dateTimeObj.format(formatDateTime));

        formatDateTime = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
        System.out.println("Formato 2: " +  dateTimeObj.format(formatDateTime));

    }
    
}
