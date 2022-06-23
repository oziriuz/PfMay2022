package Methods.exercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int limit = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= limit; i++) {
            if (isDigitSumDivisibleBy8(i) && hasOddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean hasOddDigit(int n) {
        int digit;
        while (n > 0) {
            digit = n % 10;
            if (digit % 2 == 1) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

    private static boolean isDigitSumDivisibleBy8(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum % 8 == 0;

    }
}
