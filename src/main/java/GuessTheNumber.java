import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int numberToGuess = randomNumber();
        System.out.println("Guess the number (from 0 to 99)! You have 5 chances.");


        for (int i = 0; i < 5; i++) {
            String inputValue = inputFromUser();
            inputValue = repeatInputValueUntilInRange(inputValue);
            int inputNumber = getNumber(inputValue);

            if (inputNumber == numberToGuess) {
                System.out.println("You guessed it!");
                break;
            } else {
                if ((4 - i) > 0) {
                    guideIfUserInputHigherOrLowerThanRandNumber(numberToGuess, inputNumber);
                    System.out.println("Please try again. You have: " + (4 - i) + " chance(s) left!");
                } else {
                    System.out.println("Sorry you didn't guess the number, the answer was: " + numberToGuess);
                }
            }
        }
    }

    private static void guideIfUserInputHigherOrLowerThanRandNumber(int numberToGuess, int inputNumber) {
        if (inputNumber > numberToGuess) {
            System.out.println("Your number is GREATER than the one you are trying to guess.");
        } else {

            System.out.println("Your number is LOWER than the one you are trying to guess.");
        }
    }

    private static String repeatInputValueUntilInRange(String inputValue) {
        while (!isInputValidated(inputValue)) {
            inputValue = inputFromUser();
        }
        return inputValue;
    }

    private static int randomNumber() {
        return new Random().nextInt(100);
    }

    private static boolean isInputValidated(String inputFromUser) {
        if (isValueInt(inputFromUser)) {
            if (!isValueNotInRange(getNumber(inputFromUser))) {
                return true;
            } else {
                System.out.println("Value is not in range. This entry won't be counted as a guess. You can pick only numbers from 0 to 99 range.");
                return false;
            }

        } else {
            System.out.println("Only whole numbers are accepted. This entry won't be counted as a guess. You can pick only numbers from 0-99 range.");
            return false;
        }
    }

    private static boolean isValueNotInRange(int numberFromUser) {
        return numberFromUser < 0 || numberFromUser > 99;
    }

    private static boolean isValueInt(String inputString) {
        try {
            getNumber(inputString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static Integer getNumber(String inputString) {
        return Integer.parseInt(inputString);
    }

    private static String inputFromUser() {
        return scanner.nextLine();
    }
}
