import java.util.Random;
import java.util.Scanner;

public class MultiplicationExam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score;

        do {
            score = 0;
            for (int i = 0; i < 10; i++) {
                int num1 = random.nextInt(10) + 1;
                int num2 = random.nextInt(10) + 1;

                System.out.println("What is " + num1 + " x " + num2 + "?");
                int answer = scanner.nextInt();

                if (answer == num1 * num2) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong. The correct answer is " + (num1 * num2));
                }
            }
            if (score == 10) {
                System.out.println("Congratulations! You've mastered the multiplication tables!");
            } else {
                System.out.println("Your score is " + score + "/10. Try again.");
            }
        } while (score != 10);
    }
}
