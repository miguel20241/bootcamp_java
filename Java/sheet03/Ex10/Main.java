package Java.sheet03.Ex10;

public class Main extends Thread {
    public static void main(String[] args) {
        Main mainObj = new Main();
        Thread thread = new Thread(mainObj);
        
        thread.start();       
        
        System.out.println("Fin del main.");
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                Thread.sleep(1000);
                
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Fin del thread.");
    }
}   
