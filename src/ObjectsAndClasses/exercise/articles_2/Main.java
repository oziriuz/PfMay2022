package ObjectsAndClasses.exercise.articles_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Article> articleList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split(", ");
            String title = inputArr[0];
            String content = inputArr[1];
            String author = inputArr[2];

            Article article = new Article(title, content, author);
            articleList.add(article);
        }

        //this input is for fun :)
        String strangeInput = scanner.nextLine();

        for (Article article : articleList) {
            System.out.println(article.toString());
        }
    }
}
