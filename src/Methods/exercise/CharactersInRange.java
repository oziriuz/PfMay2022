package Methods.exercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char startSymbol = scanner.nextLine().charAt(0);
        char stopSymbol = scanner.nextLine().charAt(0);

        printCharInRange(startSymbol, stopSymbol);
    }

    private static void printCharInRange(char c1, char c2) {
        char letterStart;
        char letterStop;

        if (c1 < c2) {
            letterStart = (char) (c1 + 1);
            letterStop = c2;
        } else {
            letterStart = (char) (c2 + 1);
            letterStop = c1;
        }

        while (letterStart < letterStop) {
            System.out.printf("%c ", letterStart);
            letterStart++;
        }
    }
}
