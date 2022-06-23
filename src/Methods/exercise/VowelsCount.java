package Methods.exercise;

import java.util.Locale;
import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        
        input = input.toLowerCase(Locale.ROOT);

        int result = vowelsCount(input);
        System.out.println(result);
    }

    private static int vowelsCount(String input) {
        int counter = 0;
        for (char letter : input.toCharArray()) {
            switch (letter) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    counter++;
                    break;
                default:
                    break;

            }
        }
        return counter;
    }
}
