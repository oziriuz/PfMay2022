package TextProcessing.lab;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            StringBuilder newStr = new StringBuilder();

            newStr.append(input);
            newStr.reverse();
            System.out.printf("%s = %s%n", input, newStr);

            input = scanner.nextLine();
        }
    }
}
