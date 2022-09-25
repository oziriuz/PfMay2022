package TextProcessing.lab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for (String word : bannedWords) {
            if (text.contains(word)) {
                text = text.replace(word, "*".repeat(word.length()));
            }
        }

        System.out.println(text);
    }
}
