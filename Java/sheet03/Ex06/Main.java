package Java.sheet03.Ex06;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        arrList.add(10);
        arrList.add(15);
        arrList.add(20);
        arrList.add(25);

        Iterator<Integer> it = arrList.iterator();

        while (it.hasNext()) {
            if (it.next() % 2 != 0) {
                it.remove();
            }
        }

        System.out.println("Lista después de eliminar impares: " + arrList);
    }
}