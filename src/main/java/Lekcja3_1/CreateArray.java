package Lekcja3_1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CreateArray {

    public static void main(String[] args) {
        Utils utils = new Utils();
        printMessage("To create the array insert whole number, which will be its size");
        int size = utils.getNumber(utils.repeatInputUntilInRange(utils.inputFromUser(), 1, 50));

        printMessage("Insert whole numbers to fill the array of size: " + size);
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            printMessage("Add value for array's " + (i + 1) + " number.");
            numbers[i] = utils.getNumber(utils.repeatInputUntilInRange(utils.inputFromUser(), Integer.MIN_VALUE, Integer.MAX_VALUE));
        }
        printMessage("Your array:" + Arrays.toString(numbers));

        final float arithmeticMean = getArithmeticMean(getSum(numbers), numbers);
        final int maxArrayValue = getMaxArrayValue(numbers);

        final float arithmeticMean2 = getArithmeticMean(getSum2(numbers), numbers);
        int maxArrayValue2 = getMaxArrayValue2(numbers);

        printMessage("Arithmetic mean of values in the array equals to: " + arithmeticMean + ". Max value in the array: " + maxArrayValue);
        printMessage("Other way: Arithmetic mean: " + arithmeticMean2 + ". Max value in the array: " + maxArrayValue2);

    }

    private static float getArithmeticMean(int sumOfArray, int[] countedArray) {
        return (float) sumOfArray / countedArray.length;
    }
    private static int getSum(int[] intArray) {
        return Arrays.stream(intArray).sum();
    }
    private static int getMaxArrayValue(int[] intArray) {
        return IntStream.of(intArray).max().orElse(0);
    }
    private static int getMaxArrayValue2(int[] numbers) {
        int maxArrayValue2 = numbers[0];
        for (int y : numbers) {
            if (y > maxArrayValue2) {
                maxArrayValue2 = y;
            }
        }
        return maxArrayValue2;
    }
    private static int getSum2(int[] numbers) {
        int sum2 = 0;
        for (int x : numbers) {
            sum2 += x;
        }
        return sum2;
    }
    private static void printMessage(String messageText) {
        System.out.println(messageText);
    }

}