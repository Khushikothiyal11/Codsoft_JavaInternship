import java.util.Random;
import java.util.Scanner;
class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberOfRounds = 3;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        for (int round = 1; round <= numberOfRounds; round++) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("\nRound " + round + ":");

            while (true) {
                System.out.print("Enter your guess (" + lowerBound + " - " + upperBound + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += attempts;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts >= 5) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber + ".");
                    break;
                }
            }
        }

        System.out.println("\nGame Over. Your total score is: " + score);
    }
}