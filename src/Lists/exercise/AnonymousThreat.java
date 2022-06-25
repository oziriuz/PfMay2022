package Lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays.stream(scanner.nextLine().split(" +"))
                .collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" +");

        while (!command[0].equals("3:1")) {
            if (command[0].equals("merge")) {
                int startIndex = Integer.parseInt(command[1]);
                int stopIndex = Integer.parseInt(command[2]);
                mergeFromIndexToIndex(data, startIndex, stopIndex);
            } else if (command[0].equals("divide")) {
                int index = Integer.parseInt(command[1]);
                int parts = Integer.parseInt(command[2]);
                divideAtIndexIntoParts(data, index, parts);
            }

            command = scanner.nextLine().split(" +");
        }
        String resultString = data.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        System.out.println(resultString);
    }

    private static void divideAtIndexIntoParts(List<String> list, int index, int parts) {
        String toDivide = list.get(index);
        int symbols = toDivide.length() / parts;

        List<String> divided = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < parts; i++) {
            String group = "";
            for (int j = counter; j < counter + symbols; j++) {
                group += toDivide.charAt(j);
                if (j == counter + symbols - 1) {
                    counter = j + 1;
                    break;
                }
            }

            if (i == parts - 1) {
                for (int j = counter; j < toDivide.length(); j++) {
                    group += toDivide.charAt(j);
                }
            }
            divided.add(group);
        }
        list.remove(index);
        list.addAll(index, divided);
    }

    private static void mergeFromIndexToIndex(List<String> list, int start, int stop) {
        if (isNotValidIndex(start, list)) {
            start = 0;
        }

        if (isNotValidIndex(stop, list)) {
            stop = list.size() - 1;
        }

        StringBuilder merged = new StringBuilder();
        for (int i = start; i <= stop; i++) {
            merged.append(list.get(i));
        }

        list.set(start, String.valueOf(merged));
        if (stop >= start + 1) {
            list.subList(start + 1, stop + 1).clear();
        }
    }

    private static boolean isNotValidIndex(int index, List<String> list) {
        return index < 0 || index >= list.size();
    }
}
