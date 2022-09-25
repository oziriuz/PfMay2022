package FinalExam;

import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split(" \\| ");

        Map<String, List<String>> notebook = new LinkedHashMap<>();
        for (String s : inputArr) {
            String[] wordAndDef = s.split(": ");
            String word = wordAndDef[0];
            String definition = wordAndDef[1];

            if (!notebook.containsKey(word)) {
                notebook.put(word, new ArrayList<>());
                notebook.get(word).add(definition);
            } else {
                if (!notebook.get(word).contains(definition)) {
                    notebook.get(word).add(definition);
                }
            }
        }

        String[] wordlist = scanner.nextLine().split(" \\| ");

        String command = scanner.nextLine();

        if (command.equals("Test")) {
            for (String word : wordlist) {
                notebook.forEach((key, value) -> {
                    if (key.equals(word)) {
                        System.out.printf("%s:%n", key);
                        value.forEach(definition -> System.out.printf(" -%s%n", definition));
                    }
                });
            }
        } else if (command.equals("Hand Over")) {
            notebook.forEach((key, value) -> {
                System.out.printf("%s ", key);
            });
        }
        System.out.println();
    }
}
