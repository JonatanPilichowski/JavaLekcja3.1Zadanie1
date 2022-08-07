package Lekcja3_1;

import java.util.Scanner;

public class Utils {


    public String repeatInputUntilInRange(String inputString, int min_value, int max_value) {
        while (!isInputValidated(inputString, min_value, max_value)) {
            inputString = inputFromUser();
        }
        return inputString;
    }

    public boolean isInputValidated(String inputFromUser, int min_value, int max_value) {
        if (isValueInt(inputFromUser)) {
            return tellIfUserInputIsInRange(inputFromUser, min_value, max_value);

        } else {
            printMessage("Only whole numbers are accepted. You can pick only numbers from  " + min_value + " to " + max_value + " range.");
            return false;
        }
    }
    public boolean tellIfUserInputIsInRange(String inputFromUser, int min_value, int max_value) {
        if (!isValueNotInRange(getNumber(inputFromUser), min_value, max_value)) {
            return true;
        } else {
            printMessage("Value is not in range. You can pick only numbers from " + min_value + " to " + max_value + " range.");
            return false;
        }
    }

    public boolean isValueNotInRange(int numberFromUser, int min_value, int max_value) {
        return numberFromUser < min_value || numberFromUser > max_value;
    }

    public Integer getNumber(String inputString) {
        return Integer.parseInt(inputString);
    }

    public boolean isValueInt(String inputString) {
        try {
            getNumber(inputString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public String inputFromUser() {
        Scanner scanner= new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printMessage(String messageText){
        System.out.println(messageText);
    }
}