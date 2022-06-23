package Methods.exercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMiddleChar(input);
    }

    private static void printMiddleChar(String s) {
        if (s.length() % 2 == 1) {
            System.out.println(s.charAt(s.length() / 2));
        } else {
            System.out.print(s.charAt(s.length() / 2 - 1));
            System.out.println(s.charAt(s.length() / 2));
        }
    }
}
