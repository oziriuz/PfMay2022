package MapsLambaApi.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> bag = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            String item = input;
            Integer value = Integer.parseInt(scanner.nextLine());

            if (bag.containsKey(item)) {
                bag.put(item, bag.get(item) + value);
            } else {
                bag.put(item, value);
            }
            input = scanner.nextLine();
        }

        bag.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
