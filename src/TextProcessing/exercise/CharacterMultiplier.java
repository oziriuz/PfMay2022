package TextProcessing.exercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String firstText = input.split(" ")[0];
        String secondText = input.split(" ")[1];

        int totalSum = 0;

        int minLength = Math.min(firstText.length(), secondText.length());
        int maxLength = Math.max(firstText.length(), secondText.length());

        for (int i = 0; i < minLength; i++) {
            totalSum += firstText.charAt(i) * secondText.charAt(i);
        }

        for (int i = maxLength - 1; i >= minLength; i--) {
            if (firstText.length() > secondText.length()) {
                totalSum += firstText.charAt(i);
            } else {
                totalSum += secondText.charAt(i);
            }
        }

        System.out.println(totalSum);
    }
}
