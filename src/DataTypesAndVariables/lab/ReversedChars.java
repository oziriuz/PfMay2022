package DataTypesAndVariables.lab;

import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = new char[3];
        for (int i = 0; i < input.length; i++) {
            input[i] = scanner.nextLine().charAt(0);
        }
        for (int i = input.length - 1; i >= 0; i--) {
            System.out.print(input[i] + " ");
        }
    }
}
