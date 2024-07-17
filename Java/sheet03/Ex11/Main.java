package Java.sheet03.Ex11;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cadenasArr = new ArrayList<String>();

        cadenasArr.add("Cherry");
        cadenasArr.add("banana");
        cadenasArr.add("Apple");
       
        cadenasArr.sort((cad1, cad2) -> cad1.compareToIgnoreCase(cad2));

        cadenasArr.forEach((cad) ->  System.out.println(cad)); 
    }
}
