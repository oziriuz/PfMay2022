package Methods.exercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            System.out.println(isPalindrome(input));
            input = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(String str) {
        StringBuilder temp = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            temp.append(str.charAt(i));
        }

        String strBack = String.valueOf(temp);

        return str.equals(strBack);
    }
}
