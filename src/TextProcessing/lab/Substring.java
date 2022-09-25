package TextProcessing.lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String word = scanner.nextLine();

        do {
            word = word.replace(key, "");
        } while (word.contains(key));

        System.out.println(word);
    }
}
