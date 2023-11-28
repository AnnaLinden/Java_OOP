package task2;

public class SafeArrayListTest {
    public static void main(String[] args) throws InterruptedException {
        SafeArrayList<String> safeList = new SafeArrayList<>();

        // rinnable for adding elements
        Runnable addTask = () -> {
            for (int i = 0; i < 1000; i++) {
                safeList.add("Element " + i);
            }
        };

        // runnable for removing elements
        Runnable removeTask = () -> {
            for (int i = 0; i < 500; i++) {
                if (safeList.size() > 0) {
                    safeList.remove(0);
                }
            }
        };
        Thread thread1 = new Thread(addTask);
        Thread thread2 = new Thread(addTask);
        Thread thread3 = new Thread(removeTask);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Final size: " + safeList.size());

    }

}
