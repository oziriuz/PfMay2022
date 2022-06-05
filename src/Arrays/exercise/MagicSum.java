package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int magicSum = Integer.parseInt(scanner.nextLine());

        while (numbers.length > 1) {

            int[] condensed = new int[numbers.length - 2];
            boolean isFound = false;

            for (int current = 0; current < numbers.length; current++) {
                for (int rightElement = current + 1; rightElement < numbers.length; rightElement++) {
                    if (magicSum == numbers[current] + numbers[rightElement]) {
                        System.out.printf("%d %d%n", numbers[current], numbers[rightElement]);

                        int newPositionCounter = 0;
                        for (int i = 0; i < numbers.length; i++) {
                            if (i != current && i != rightElement) {
                                condensed[newPositionCounter++] = numbers[i];
                            }
                        }
                        isFound = true;
                        break;
                    }
                }
                if (isFound) {
                    break;
                }
            }

            numbers = Arrays.copyOf(condensed, condensed.length);
        }
    }
}
