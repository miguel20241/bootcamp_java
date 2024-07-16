package Java.sheet03.Ex02;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbArr = new ArrayList<Integer>(); 

        numbArr.add(10);
        numbArr.add(20);
        numbArr.add(30);

        int total = 0;
        for (Integer number : numbArr) {
            total += number;
        }

        System.out.println("La suma es: " + total);

    }
}
