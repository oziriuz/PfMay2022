package BasicSyntax.MoreExercises;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int limit = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < limit; i++) {
            String input = scanner.nextLine();
            int mainDigit = Integer.parseInt(input) % 10;
            int offset = (mainDigit - 2) * 3;

            if (mainDigit == 8 || mainDigit == 9) {
                offset++;
            }

            char output = (char) ((offset + input.length() - 1) + 97);

            if (mainDigit == 0) {
                output = ' ';
            }
            System.out.print(output);
        }
    }
}
