package Lekcja3_1;

import java.util.Random;

public class GuessTheNumber {
    private static final int chancesNumber = 5;

    public static void main(String[] args) {


        Utils utils = new Utils();
        final int min_value = 0;
        final int max_value = 99;
        int numberToGuess = randomNumber();
        int inputNumber;
        String inputString;
        printMessage("Guess the number (from " + min_value + " to " + max_value + ")! You have 5 chances.");

        for (int i = 1; i <= chancesNumber; i++) {
            inputString = utils.repeatInputUntilInRange(utils.inputFromUser(), min_value, max_value);
            inputNumber = utils.getNumber(inputString);

            if (inputNumber == numberToGuess) {
                printMessage("You guessed it!");
                break;
            } else {
                giveChanceToGuess(numberToGuess, i, inputNumber);
            }
        }
    }

    private static void printMessage(String messageText) {
        System.out.println(messageText);
    }

    private static int randomNumber() {
        return new Random().nextInt(100);
    }

    private static void giveChanceToGuess(int numberToGuess, int i, int inputNumber) {
        int chancesLeftInt = chancesNumber - i;
        if (chancesLeftInt > 0) {
            tellIfUserInputHigherOrLowerThanRandNumber(numberToGuess, inputNumber);
            printMessage("Please try again. You have: " + chancesLeftInt + " chance(s) left!");
        } else {
            System.out.println("Sorry you didn't guess the number, the answer was: " + numberToGuess);
        }
    }

    private static void tellIfUserInputHigherOrLowerThanRandNumber(int numberToGuess, int inputNumber) {
        if (inputNumber > numberToGuess) {
            System.out.println("Your number is GREATER than the one you are trying to guess.");
        } else {

            System.out.println("Your number is LOWER than the one you are trying to guess.");
        }
    }


}
