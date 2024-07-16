package Java.sheet03.Ex03;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> wordsArr = new LinkedList<String>();

        wordsArr.add("Hola");
        wordsArr.add("Mundo");
        wordsArr.add("Java");

        for (String word : wordsArr) {
            System.out.println(word);
        }
    }
}
