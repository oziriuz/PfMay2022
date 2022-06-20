package Methods.lab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Math.abs(Integer.parseInt(scanner.nextLine()));

        int result = getMultipleOfEvenAndOdds(n);
        System.out.println(result);
    }

    private static int getMultipleOfEvenAndOdds(int n) {
        int evenSum = getEvenSum(n);
        int oddSum = getOddSum(n);

        return evenSum * oddSum;
    }

    private static int getOddSum(int n) {
        int sum = 0;
        int number = 0;

        while (n > 0) {
            number = n % 10;
            if (number % 2 != 0) {
                sum += n % 10;
            }
            n /= 10;
        }
        return sum;
    }

    private static int getEvenSum(int n) {
        int sum = 0;
        int number = 0;

        while (n > 0) {
            number = n % 10;
            if (number % 2 == 0) {
                sum += n % 10;
            }
            n /= 10;
        }
        return sum;
    }
}
