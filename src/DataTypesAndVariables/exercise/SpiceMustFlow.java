package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yeild = Integer.parseInt(scanner.nextLine());

        int days = 0;
        int totalAmount = 0;
        while (yeild >= 100) {
            int spices = yeild - 26;
            totalAmount += spices;
            days++;
            yeild -= 10;
        }

        System.out.println(days);
        if (totalAmount >= 26) {
            totalAmount -= 26;
        } else {
            totalAmount = 0;
        }
        System.out.println(totalAmount);
    }
}
