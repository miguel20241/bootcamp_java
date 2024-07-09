package Java.Ex06;

public class Arrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        arr[0] = 10;
        arr[1] = 9;
        arr[2] = 8;

        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
    }
}