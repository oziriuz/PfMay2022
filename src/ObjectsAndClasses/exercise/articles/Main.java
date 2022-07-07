package ObjectsAndClasses.exercise.articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(", ");
        String title = inputArr[0];
        String content = inputArr[1];
        String author = inputArr[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(": ");
            String command = input[0];
            String newValue = input[1];
            switch (command) {
                case "Edit":
                    article.edit(newValue);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(newValue);
                    break;
                case "Rename":
                    article.rename(newValue);
                    break;
                default:
                    break;
            }
        }

        System.out.printf(article.toString());
    }
}
