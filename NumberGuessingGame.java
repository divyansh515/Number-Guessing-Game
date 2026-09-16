package Project;

import java.util.Scanner;

public class NumberGuessingGame {

    enum GuessResult{
        LOW,
        HIGH,
        CORRECT
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        playGame(sc);

    }

    public static int generateSecretNumber(){
        return (int)(Math.random()*100) + 1;
    }

    public static boolean isValidGuess(int userGuess){
        return userGuess>=1 && userGuess <=100;
    }

    private static GuessResult checkGuess(int secretNumber, int userGuess){
        if(userGuess < secretNumber)
            return GuessResult.LOW;
        else if(userGuess > secretNumber)
            return GuessResult.HIGH;
        else
            return GuessResult.CORRECT;
    }

    public static void playGame(Scanner sc){
        char play ='y';
        while (play == 'y') {
            System.out.println("-------------------------------Number Guessing Game-------------------------------------");

            int secretNumber = generateSecretNumber();

            int userGuess;
            int attempts = 0;


            do {
                System.out.print("Guess a number between 1 to 100: ");
                userGuess = sc.nextInt();

                if (!(isValidGuess(userGuess))) {
                    System.out.println("Invalid number entered");
                    continue;
                }
                attempts++;
                GuessResult result = checkGuess(secretNumber,userGuess);
                System.out.println(result);
                if(result == GuessResult.CORRECT)
                    System.out.println("You have taken " + attempts + " attempts");

                if (attempts == 5 && secretNumber != userGuess) {
                    System.out.println("Game Over");
                    System.out.println("Secret Number: " + secretNumber);
                }
            }
            while (secretNumber != userGuess && attempts < 5);

            System.out.println("Do you want to play again? (y/n) ");
            play = sc.next().charAt(0);
        }
    }
}
