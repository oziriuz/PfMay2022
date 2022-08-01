package MapsLambaApi.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> items = new LinkedHashMap<>();
        items.put("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);

        Map<String, Integer> junks = new LinkedHashMap<>();

        boolean isWon = false;
        while (!isWon) {
            String[] inputData = scanner.nextLine().split(" ");

            for (int i = 0; i < inputData.length; i += 2) {
                Integer quantity = Integer.parseInt(inputData[i]);
                String item = inputData[i + 1].toLowerCase();

                if (items.containsKey(item)) {
                    items.put(item, items.get(item) + quantity);
                } else {
                    if (junks.containsKey(item)) {
                        junks.put(item, junks.get(item) + quantity);
                    } else {
                        junks.put(item, quantity);
                    }
                }

                if (items.get("shards") >= 250) {
                    isWon = true;
                    items.put("shards", items.get("shards") - 250);
                    System.out.println("Shadowmourne obtained!");
                    break;
                } else if (items.get("fragments") >= 250) {
                    isWon = true;
                    items.put("fragments", items.get("fragments") - 250);
                    System.out.println("Valanyr obtained!");
                    break;
                } else if (items.get("motes") >= 250) {
                    isWon = true;
                    items.put("motes", items.get("motes") - 250);
                    System.out.println("Dragonwrath obtained!");
                    break;
                }
            }
        }

        items.forEach((key, value) -> System.out.println(key + ": " + value));
        junks.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
