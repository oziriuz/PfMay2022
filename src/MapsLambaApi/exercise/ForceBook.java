package MapsLambaApi.exercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> forceBook = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains(" | ")) {
                String[] inputArr = input.split(" \\| ");
                String team = inputArr[0];
                String player = inputArr[1];

                if (!forceBook.containsKey(team)) {
                    forceBook.put(team, new ArrayList<>());
                    forceBook.get(team).add(player);
                } else {
                    if (!forceBook.get(team).contains(player)) {
                        forceBook.get(team).add(player);
                    }
                }
            }

            if (input.contains(" -> ")) {
                String[] inputArr = input.split(" -> ");
                String player = inputArr[0];
                String team = inputArr[1];

                forceBook.forEach((key, value) -> value.remove(player));

                if (forceBook.containsKey(team)) {
                    forceBook.get(team).add(player);
                } else {
                    forceBook.put(team, new ArrayList<>());
                    forceBook.get(team).add(player);
                }

                System.out.printf("%s joins the %s side!%n", player, team);
            }

            input = scanner.nextLine();
        }

        forceBook.entrySet().stream().filter(entry -> entry.getValue().size() > 0)
                .forEach(entry -> {
                    System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().forEach(player -> System.out.println("! " + player));
                });
    }
}

