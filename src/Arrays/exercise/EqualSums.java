package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementIndex = -1;

        for (int current = 0; current < numbers.length; current++) {
            boolean isTop = false;

            int leftSum = 0;
            for (int leftElement = 0; leftElement < current; leftElement++) {
                leftSum += numbers[leftElement];
            }

            int rightSum = 0;
            for (int rightElement = current + 1; rightElement < numbers.length; rightElement++) {
                rightSum += numbers[rightElement];
            }

            if (leftSum == rightSum) {
                elementIndex = current;
                break;
            }
        }

        if (elementIndex !=-1) {
            System.out.println(elementIndex);
        } else {
            System.out.println("no");
        }


    }
}
