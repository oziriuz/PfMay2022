package MapsLambaApi.lab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Map<String, Integer> wordMap = new LinkedHashMap<>();
        for (String s : input) {
            String current = s.toLowerCase();
            Integer counter = wordMap.get(current);

            if (wordMap.containsKey(current)) {
                wordMap.put(current, counter + 1);
            } else {
                wordMap.put(current, 1);
            }
        }

        List<String> odds = new ArrayList<>();

        for (Map.Entry<String, Integer> entry: wordMap.entrySet()) {
            if(entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", odds));
    }
}
