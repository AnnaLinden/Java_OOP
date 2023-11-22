package agedistribution;

import java.util.Random;

public class AgeDistribution {

    public static void main(String[] args) {
        // Pre-coded age distribution data in a two-dimensional array
        int[][] ageDistribution = {
                // {Cumulative Percentage, Age}
                { 20, 20 }, // 16% are 20 years old
                { 60, 25 }, // 18% are 21 years old, cumulative 34%
                { 80, 30 }, // 18% are 22 years old, cumulative 52%
                { 100, 35 } // Ensure the total cumulative percentage is 100%
        };

        // Array to store the count of each age in the simulated data
        int[] ageCounts = new int[36]; // Assuming age ranges from 20 to 36

        // Random number generator
        Random random = new Random();

        // Generate and tally 1000 age values
        for (int i = 0; i < 1000; i++) {
            int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            int age = findAgeForRandomNumber(randomNumber, ageDistribution);
            ageCounts[age]++; // Increment the count for the corresponding age
        }

        // Display the results
        System.out.println("Simulated Age Distribution:");
        for (int age = 20; age < ageCounts.length; age++) {
            if (ageCounts[age] > 0) {
                System.out.println("Age " + age + ": " + ageCounts[age] + " students");
            }
        }
    }

    // Method to find the corresponding age for a given random number
    private static int findAgeForRandomNumber(int randomNumber, int[][] ageDistribution) {
        for (int[] ageGroup : ageDistribution) {
            if (randomNumber <= ageGroup[0]) {
                return ageGroup[1];
            }
        }
        throw new IllegalStateException("Random number does not match any age group.");
    }
}
