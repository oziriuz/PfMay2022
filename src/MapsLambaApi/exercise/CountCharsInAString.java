package MapsLambaApi.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character, Integer> symbolsCount = new LinkedHashMap<>();

        for (char symbol : text.toCharArray()) {
            if (symbol == ' ') {
                continue;
            }

            if(!symbolsCount.containsKey(symbol)) {
                symbolsCount.put(symbol, 1);
            } else {
                symbolsCount.put(symbol, symbolsCount.get(symbol) + 1);
            }
        }

        symbolsCount.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
