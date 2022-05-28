package BasicSyntax.exercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int tempNumber = number;
        int sumFactoriel = 0;

        while (tempNumber > 0) {
            int digit = tempNumber % 10;
            tempNumber /= 10;

            int factoriel = 1;
            for (int i = 1; i <= digit; i++) {
                factoriel *= i;
            }
            sumFactoriel += factoriel;
        }

        if (sumFactoriel == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
