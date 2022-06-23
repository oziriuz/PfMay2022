package Methods.exercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        int validations = 3;

        if (!isValidLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
            validations--;
        }

        if (!isValidLetterAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
            validations--;
        }

        if (!isValidTwoDigitsMinimum(password)) {
            System.out.println("Password must have at least 2 digits");
            validations--;
        }

        if (validations == 3) {
            System.out.println("Password is valid");
        }
    }

    private static boolean isValidLength(String input) {
        return input.length() >= 6 && input.length() <= 10;
    }

    private static boolean isValidLetterAndDigits(String input) {
        for (char symbol : input.toCharArray()) {
            if (symbol >= 48 && symbol <= 57) {
            } else if (symbol >= 65 && symbol <= 90) {
            } else if (symbol >= 97 && symbol < 122) {
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidTwoDigitsMinimum(String input) {
        int digitCounter = 0;
        for (char symbol : input.toCharArray()) {
            if (symbol >= 48 && symbol <= 57) {
                digitCounter++;
            }
        }

        return digitCounter >= 2;
    }
}
