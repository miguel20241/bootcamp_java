package Java.sheet03.Ex05;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> hashset = new HashSet<Integer>();

        hashset.add(10);
        hashset.add(20);
        hashset.add(30);
        hashset.add(10);

        for (Integer number : hashset) {
            System.out.println(number);
        }
    }
}
