package Multi_threaded_Number_Printing;

public class NumberPrinter {
    public static void main(String[] args) {
        Printer printer = new Printer(20);
        Thread oddThread = new Thread(() -> printer.printNumber(false));
        Thread evenThread = new Thread(() -> printer.printNumber(true));

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Printing complete.");
    }
}

class Printer {
    private int maxNumber;
    private int number = 1;

    public Printer(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public synchronized void printNumber(boolean isEven) {
        while (number <= maxNumber) {
            try {
                if (isEven != (number % 2 == 0)) {
                    wait();
                } else {
                    System.out.println((isEven ? "Even" : "Odd") + " Thread: " + number);
                    number++;
                    notify();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted");
            }
        }
    }
}
