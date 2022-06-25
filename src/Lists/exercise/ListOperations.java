package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("End")) {
            switch (input[0]) {
                case "Add":
                    numbersList.add(Integer.valueOf(input[1]));
                    break;
                case "Insert":
                    int index = Integer.parseInt(input[2]);
                    int number = Integer.parseInt(input[1]);
                    if (index < numbersList.size() && index >= 0) {
                        numbersList.add(index, number);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indexR = Integer.parseInt(input[1]);
                    if (indexR < numbersList.size() && indexR >= 0) {
                        numbersList.remove(indexR);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    if (input[1].equals("left")) {
                        int times = Integer.parseInt(input[2]);
                        for (int i = 0; i < times; i++) {
                            numbersList.add(numbersList.get(0));
                            numbersList.remove(0);
                        }
                    } else if (input[1].equals("right")) {
                        int times = Integer.parseInt(input[2]);
                        for (int i = 0; i < times; i++) {
                            numbersList.add(0, numbersList.get(numbersList.size() - 1));
                            numbersList.remove(numbersList.size() - 1);
                        }
                    }
                    break;
                default:
                    break;
            }

            input = scanner.nextLine().split(" ");
        }

        String resultString = numbersList.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        System.out.println(resultString);
    }
}
