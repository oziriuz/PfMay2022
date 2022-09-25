package TextProcessing.exercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] codes = input.split("\\s+");

        double totalSum = 0.0;
        for (String code : codes) {
            double number = getModifiedNumber(code);
            totalSum += number;
        }

        System.out.printf("%.2f", totalSum);
    }

    private static double getModifiedNumber(String code) {
        char firstLetter = code.charAt(0);
        char secondLetter = code.charAt(code.length() - 1);
        double number = Double.parseDouble(code.replace(firstLetter, ' ')
                .replace(secondLetter, ' ').trim());

        if (Character.isUpperCase(firstLetter)) {
            number /= (firstLetter - 64);
        } else {
            number *= (firstLetter - 96);
        }

        if (Character.isUpperCase(secondLetter)) {
            number -= (secondLetter - 64);
        } else {
            number += (secondLetter - 96);
        }

        return number;
    }
}

