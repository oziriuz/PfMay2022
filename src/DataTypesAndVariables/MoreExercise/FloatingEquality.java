package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double eps = 0.000001;

        double numberA = Double.parseDouble(scanner.nextLine());
        double numberB = Double.parseDouble(scanner.nextLine());

        double differance = Math.abs(numberA - numberB);

        if (differance < eps) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
