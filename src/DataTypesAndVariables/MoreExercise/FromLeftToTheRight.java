package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            long leftNumber = Long.parseLong(input.split(" ")[0]);
            long rightNumber = Long.parseLong(input.split(" ")[1]);
            long biggerNumber =Math.abs(Math.max(leftNumber, rightNumber));

            int sumDigits = 0;
            while (biggerNumber > 0) {
                sumDigits += biggerNumber % 10;
                biggerNumber /= 10;
            }
            System.out.println(sumDigits);
        }
    }
}
