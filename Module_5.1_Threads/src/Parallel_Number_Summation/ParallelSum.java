package Parallel_Number_Summation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

public class ParallelSum {
    public static void main(String[] args) throws Exception {
        int numberOfThreads = 6;
        int maxNumber = 100;
        int rangePerThread = maxNumber / numberOfThreads;

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<Integer>> futures = new ArrayList<>();

        // Submit tasks to ExecutorService
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * rangePerThread + 1;
            int end = (i + 1) * rangePerThread;
            futures.add(executor.submit(() -> sumRange(start, end)));
        }

        // Calculate total sum
        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get(); // get() waits for the task to complete
        }

        executor.shutdown(); // Always remember to shutdown the executor

        System.out.println("Total sum: " + totalSum);
    }

    private static int sumRange(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}
