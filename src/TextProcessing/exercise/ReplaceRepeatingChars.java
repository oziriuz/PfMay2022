package TextProcessing.exercise;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder();
        char uniqueSymbol ='\0';

        for (char symbol : input.toCharArray()) {
            if (symbol != uniqueSymbol){
                text.append(symbol);
                uniqueSymbol = symbol;
            }
        }

        System.out.println(text);
    }
}
