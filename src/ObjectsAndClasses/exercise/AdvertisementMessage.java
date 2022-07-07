package ObjectsAndClasses.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phrases = new ArrayList<>();
        phrases = List.of(new String[]{"Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."});

        List<String> events = new ArrayList<>();
        events = List.of(new String[]{"Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"});

        List<String> authors = new ArrayList<>();
        authors = List.of(new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"});

        List<String> cities = new ArrayList<>();
        cities = List.of(new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"});

        int n = Integer.parseInt(scanner.nextLine());

        Random rnd = new Random();
        int randomPhrase = 0;
        int randomEvent = 0;
        int randomAuthor = 0;
        int randomCity = 0;

        for (int i = 0; i < n; i++) {
            randomPhrase = rnd.nextInt(phrases.size());
            randomEvent = rnd.nextInt(events.size());
            randomAuthor = rnd.nextInt(authors.size());
            randomCity = rnd.nextInt(cities.size());

            System.out.printf("%s %s %s - %s%n",
                    phrases.get(randomPhrase),
                    events.get(randomEvent),
                    authors.get(randomAuthor),
                    cities.get(randomCity));
        }
    }
}
