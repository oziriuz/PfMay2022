package DataTypesAndVariables.lab;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int currentNumber = i;

            int sumDigits = 0;
            while (currentNumber > 0) {
                sumDigits += currentNumber % 10;
                currentNumber /= 10;
            }

            String result;
            if (sumDigits == 5 || sumDigits == 7 || sumDigits == 11) {
                result = i + " -> " + "True";
            } else {
                result = i + " -> " + "False";
            }

            System.out.println(result);
        }
    }
}
