package DataTypesAndVariables.lab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= input; i++) {
            int current = i;
            int sum = 0;

            while (current > 0) {
                sum += current % 10;
                current = current / 10;
            }

            String result;

            if (sum == 5 || sum == 7 || sum == 11) {
                result = i + " -> " + "True";
            } else {
                result = i + " -> " + "False";
            }

            System.out.println(result);
        }
    }
}