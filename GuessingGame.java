import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the Guessing Game!");
        int attemptsLimit = 5;
        int totalRounds = 0;
        int totalAttempts = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            int targetNumber = random.nextInt(100) + 1;
            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            int attempts = 0;

            while (attempts < attemptsLimit) {
                try {
                    int userGuess = Integer.parseInt(scanner.nextLine());
                    attempts++;

                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed the correct number!");
                        break;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            totalRounds++;
            totalAttempts += attempts;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Game over!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Average attempts per round: " + (double) totalAttempts / totalRounds);
    }
}
