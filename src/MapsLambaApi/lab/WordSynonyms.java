package MapsLambaApi.lab;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> dictionary = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synomym = scanner.nextLine();

            dictionary.putIfAbsent(word, new ArrayList<>());
            dictionary.get(word).add(synomym);
        }

        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
            System.out.printf("%s - %s%n",
                    entry.getKey(),
                    String.join(", ", entry.getValue()));
        }
    }
}
