package Multi_threaded_Number_Printing;

class OddThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 20; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Odd Thread interrupted");
                e.printStackTrace();
                return;
            }
        }
    }

}

class EvenRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Even Thread interrupted");
                e.printStackTrace();
            }
        }

    }

}

public class Main {

    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        Thread evenThread = new Thread(new EvenRunnable());
        oddThread.start();
        evenThread.start();

    }

}
