package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int longestSequence = 1;
        int numberInLongestSequence = Integer.MIN_VALUE;

        for (int current = numbers.length - 1; current > 0; current--) {
            int sequenceCounter = 1;
            for (int leftNum = current - 1; leftNum >= 0; leftNum--) {
                if (numbers[current] == numbers[leftNum]) {
                    sequenceCounter++;
                }
                if (numbers[current] != numbers[leftNum] || leftNum == 0){
                    if (sequenceCounter >= longestSequence) {
                        longestSequence = sequenceCounter;
                        numberInLongestSequence = numbers[current];
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < longestSequence; i++) {
            System.out.print(numberInLongestSequence + " ");
        }
    }
}
