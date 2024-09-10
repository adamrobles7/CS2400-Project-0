import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PowerBallLottery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user to pick five numbers between 1 and 69
        System.out.println("Welcome to California Powerball Lottery!");
        System.out.println(" ");
        System.out.println("Please pick five numbers between 1 and 69:");
        int[] userNumbers = new int[5];
        for (int i = 0; i < 5; i++) {
            int number;
            do {
                System.out.print("Enter number " + (i + 1) + ": ");
                number = scanner.nextInt();
                if (number < 1 || number > 69) {
                    System.out.println(" ");
                    System.out.println("Invalid input. Please enter a number between 1 and 69.");
                } else {
                    userNumbers[i] = number;
                }
            } while (number < 1 || number > 69);
        }
        
        // Prompt user to pick a Powerball number between 1 and 26
        int userPowerBall;
        do {
            System.out.println(" ");
            System.out.println("Now, pick a Powerball number between 1 and 26:");
            userPowerBall = scanner.nextInt();
            if (userPowerBall < 1 || userPowerBall > 26) {
                System.out.println(" ");
                System.out.println("Invalid input. Please enter a number between 1 and 26.");
            }
        } while (userPowerBall < 1 || userPowerBall > 26);
        
        // Generate winning numbers
        int[] winningNumbers = generateWinningNumbers();
        int winningPowerBall = generatePowerBall();
        
        // Display winning numbers
        System.out.println("\nWinning Numbers: " + Arrays.toString(winningNumbers));
        System.out.println("Winning Powerball: " + winningPowerBall);
        
        // Check for matches
        int matchedNumbers = countMatches(userNumbers, winningNumbers);
        boolean matchedPowerBall = userPowerBall == winningPowerBall;
        
        // Display results
        System.out.println("\nYou matched " + matchedNumbers + " numbers.");
        System.out.println("Your Powerball matched: " + (matchedPowerBall ? "Yes" : "No"));
        
        // Determine if the user won
        if (matchedNumbers == 5 && matchedPowerBall) {
            System.out.println("Congratulations! You won the jackpot!");
        } else {
            System.out.println("Better luck next time!");
        }
        
        scanner.close();
    }
    
    // Method to generate an array of five unique random numbers between 1 and 69
    private static int[] generateWinningNumbers() {
        Random random = new Random();
        int[] winningNumbers = new int[5];
        for (int i = 0; i < 5; i++) {
            int num;
            do {
                num = random.nextInt(69) + 1;
            } while (contains(winningNumbers, num));
            winningNumbers[i] = num;
        }
        return winningNumbers;
    }
    
    // Method to generate a random Powerball number between 1 and 26
    private static int generatePowerBall() {
        Random random = new Random();
        return random.nextInt(26) + 1;
    }
    
    // Method to check if an array contains a specific value
    private static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
    
    // Method to count the number of matches between user numbers and winning numbers
    private static int countMatches(int[] userNumbers, int[] winningNumbers) {
        int count = 0;
        for (int userNum : userNumbers) {
            for (int winningNum : winningNumbers) {
                if (userNum == winningNum) {
                    count++;
                }
            }
        }
        return count;
    }
}