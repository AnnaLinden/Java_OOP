package Parallel_Number_Summation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

public class ParallelSum {
    public static void main(String[] args) throws Exception {
        int numberOfThreads = 6; // Number of threads to use
        int maxNumber = 100; // Maximum number in the range to sum
        int rangePerThread = maxNumber / numberOfThreads; // Divide range among threads

        // ExecutorService manages a pool of threads
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        // Future to hold the results of asynchronous computations
        List<Future<Integer>> futures = new ArrayList<>();

        // Submitting tasks to the ExecutorService
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * rangePerThread + 1; // Calculate start of range for this thread
            int end = (i + 1) * rangePerThread; // Calculate end of range for this thread
            // Submit a callable task that returns the sum of a range
            futures.add(executor.submit(() -> sumRange(start, end)));
        }

        // Calculate the total sum by adding up results from all futures
        int totalSum = 0;
        for (Future<Integer> future : futures) {
            // Retrieve the result of a computation when it's done
            totalSum += future.get(); // get() blocks until the computation is complete
        }

        // Shutdown the ExecutorService. It's important to shutdown to stop accepting
        // new tasks
        executor.shutdown();

        System.out.println("Total sum: " + totalSum);
    }

    // Method to sum a range of numbers
    private static int sumRange(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i; // Add each number in the range to sum
        }
        return sum; // Return the sum of the range
    }
}
