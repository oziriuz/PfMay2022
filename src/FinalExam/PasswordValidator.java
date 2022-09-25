package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String[] commandArr = scanner.nextLine().split(" ");

        while (!commandArr[0].equals("Complete")) {
            switch (commandArr[0]) {
                case "Make":
                    if (commandArr[1].equals("Upper")) {
                        password = makeUpperAtPosition(password, Integer.parseInt(commandArr[2]));
                        System.out.println(password);
                    }

                    if (commandArr[1].equals("Lower")) {
                        password = makeLowerAtPosition(password, Integer.parseInt(commandArr[2]));
                        System.out.println(password);
                    }
                    break;
                case "Insert":
                    password = insertCharAtPosition(password, Integer.parseInt(commandArr[1]), commandArr[2].charAt(0));
                    System.out.println(password);
                    break;
                case "Replace":
                    password = shiftAllCharsPlusGivenValue(password, commandArr[1].charAt(0), Integer.parseInt(commandArr[2]));
                    System.out.println(password);
                    break;
                case "Validation":
                    printPasswordValidation(password);
                    break;
            }

            commandArr = scanner.nextLine().split(" ");
        }

    }

    private static String shiftAllCharsPlusGivenValue(String input, char ch, int value) {
        char[] updatedArr = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ch) {
                updatedArr[i] = (char) (ch + value);
            } else {
                updatedArr[i] = input.charAt(i);
            }
        }
        return new String(updatedArr);
    }

    private static String insertCharAtPosition(String input, int position, char ch) {
        if (position >= 0 && position < input.length()) {
            int length = input.length();
            char[] updatedArr = new char[length + 1];
            input.getChars(0, position, updatedArr, 0);
            updatedArr[position] = ch;
            input.getChars(position, length, updatedArr, position + 1);
            return new String(updatedArr);
        } else {
            return input;
        }
    }

    private static String makeUpperAtPosition(String input, int position) {
        if (position >= 0 && position < input.length()) {
            input = input.substring(0, position) + Character.toUpperCase(input.charAt(position)) + input.substring(position + 1);
        }
        return input;
    }

    private static String makeLowerAtPosition(String input, int position) {
        if (position >= 0 && position < input.length()) {
            input = input.substring(0, position) + Character.toLowerCase(input.charAt(position)) + input.substring(position + 1);
        }
        return input;
    }

    private static boolean hasOnlyLetterDigitsUnderScore(String input) {
        for (char symbol : input.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol != '_') {
                return false;
            }
        }
        return true;
    }

    private static boolean hasAtLeastOneUpper(String input) {
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher matcher = pattern.matcher(input);
        boolean result = matcher.find();
        return result;
    }

    private static boolean hasAtLeastOneLower(String input) {
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(input);
        boolean result = matcher.find();
        return result;
    }

    private static boolean hasAtLeastOneDigit(String input) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        boolean result = matcher.find();
        return result;
    }

    public static void printPasswordValidation(String input) {
        if (input.length() < 8) {
            System.out.println("Password must be at least 8 characters long!");
        }

        if (!hasOnlyLetterDigitsUnderScore(input)) {
            System.out.println("Password must consist only of letters, digits and _!");
        }

        if (!hasAtLeastOneUpper(input)) {
            System.out.println("Password must consist at least one uppercase letter!");
        }

        if (!hasAtLeastOneLower(input)) {
            System.out.println("Password must consist at least one lowercase letter!");
        }

        if (!hasAtLeastOneDigit(input)) {
            System.out.println("Password must consist at least one digit!");
        }
    }
}
