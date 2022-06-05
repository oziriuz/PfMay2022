package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotations; i++) {
            int temp = numbers[0];

            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            numbers[numbers.length - 1] = temp;
        }

        String result = Arrays.toString(numbers)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        System.out.println(result);
    }
}
