package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            //check for numbers and points
            boolean isNumber = false;
            for (char symbol : input.toCharArray()) {
                if (symbol >= '0' && symbol <= '9' || symbol == '.' || symbol == '-') {
                    isNumber = true;
                } else {
                    isNumber = false;
                    break;
                }

                if (symbol == '.' && input.length() == 1) {
                    isNumber = false;
                }

                if (symbol == '-' && input.length() == 1) {
                    isNumber = false;
                }
            }

            if (input.indexOf('-') > 0) {
                isNumber = false;
            }

            if (isNumber) {
                if (input.contains(".")) {
                    System.out.printf("%s is floating point type%n", input);
                } else {
                    System.out.printf("%s is integer type%n", input);
                }
            } else if (input.length() == 1) {
                System.out.printf("%s is character type%n", input);
            } else if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                System.out.printf("%s is boolean type%n", input);
            } else {
                System.out.printf("%s is string type%n", input);
            }
            input = scanner.nextLine();
        }
    }
}
