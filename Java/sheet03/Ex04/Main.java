package Java.sheet03.Ex04;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> mapList = new HashMap<String, Integer>();

        mapList.put("Ana", 25);
        mapList.put("Luis", 35);
        mapList.put("Juan", 30);

        for (String name : mapList.keySet()) {
            System.out.println(name + " tiene " + mapList.get(name) + " años.");
        }
    }
    
}
