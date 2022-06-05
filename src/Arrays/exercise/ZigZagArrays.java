package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            int firstElement = Integer.parseInt(input[0]);
            int secondElement = Integer.parseInt(input[1]);

            if (i % 2 == 0) {
                firstArray[i] = firstElement;
                secondArray[i] = secondElement;
            } else {
                firstArray[i] = secondElement;
                secondArray[i] = firstElement;
            }
        }

        String result1 = Arrays.toString(firstArray)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");

        String result2 = Arrays.toString(secondArray)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");

        System.out.println(result1);
        System.out.println(result2);
    }
}
