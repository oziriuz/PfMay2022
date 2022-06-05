package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int current = 0; current < numbers.length - 1; current++) {
            boolean isTop = false;

            for (int nextRight = current + 1; nextRight < numbers.length; nextRight++) {
                if (numbers[current] > numbers[nextRight]) {
                    isTop = true;
                } else {
                    isTop = false;
                    break;
                }
            }

            if (isTop) {
                System.out.print(numbers[current] + " ");
            }
        }

        System.out.println(numbers[numbers.length - 1]);
    }
}
