import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
   static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int numberToGuess = randomNumber();
        System.out.println("Guess the number (from 0 to 99)! You have 5 chances. " + numberToGuess);

        /*
        int number = getNumber(inputFromUser());
        System.out.println("Twoja liczba to: "+ number);
        System.exit(0);

         */

        for (int i = 0; i < 5; i++) {
            String inputFromUser=inputFromUser();
            int inputNumber = InsertEndlesslyUntilValueIsInt(inputFromUser);

            while(isValueNotInRange(inputNumber)){
                inputNumber= InsertEndlesslyUntilValueIsInt(inputFromUser);

                System.out.println("You've inserted number: "+ inputNumber + ", which is out of range. Expected range is 0-99");
            }

                if(inputNumber==numberToGuess){
                    System.out.println("You guessed it!");
                    break;
                } else {
                    if (inputNumber>numberToGuess){
                        System.out.println("Your number is GREATER than the one you are trying to guess.");
                    } else {

                        System.out.println("Your number is LOWER than the one you are trying to guess.");
                    }
                    System.out.println("Please try again. You have: "+ (4-i)+ " chances left!");
                }

            }


        System.out.println("");
        System.out.println("The end");

    }

    private static int randomNumber() {
        return new Random().nextInt(100);
    }

    private static int InsertEndlesslyUntilValueIsInt(String inputFromUser) {
        while (!isValueInt(inputFromUser)) {
            System.out.println("Only numbers are accepted. This entry won't be counted as a guess. Please try again!");
            inputFromUser=inputFromUser();
        }
        return  getNumber(inputFromUser);
    }

    private static boolean isValueNotInRange(int numberFromUser) {
        return numberFromUser < 0 || numberFromUser > 99;
    }

    private static boolean isValueInt(String inputString) {
        try {
            getNumber(inputString);
            return true;
        } catch (NumberFormatException e){
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
