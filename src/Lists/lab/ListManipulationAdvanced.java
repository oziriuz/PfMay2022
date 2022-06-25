package Lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("end")) {
            switch (input[0]) {
                case "Contains":
                    if (numbers.contains(Integer.parseInt(input[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    printEvenOrOdd(numbers, input[1]);
                    break;
                case "Get":
                    if (input[1].equals("sum")) {
                        System.out.println(sumOfNumberInList(numbers));
                    }
                    break;
                case "Filter":
                    int number = Integer.parseInt(input[2]);
                    System.out.println(filteredNumberFromList(numbers, input[1], number));
                    break;
                default:
                    break;
            }

            input = scanner.nextLine().split(" ");
        }
    }

    private static String filteredNumberFromList(List<Integer> list, String condition, int limit) {
        String result = "";
        switch (condition) {
            case "<":
                for (Integer item : list) {
                    if (item < limit) {
                        result += (item + " ");
                    }
                }
                break;
            case "<=":
                for (Integer item : list) {
                    if (item <= limit) {
                        result += (item + " ");
                    }
                }
                break;
            case ">":
                for (Integer item : list) {
                    if (item > limit) {
                        result += (item + " ");
                    }
                }
                break;
            case ">=":
                for (Integer item : list) {
                    if (item >= limit) {
                        result += (item + " ");
                    }
                }
                break;
        }
        return result;
    }

    private static int sumOfNumberInList(List<Integer> list) {
        int sum = 0;
        for (Integer item : list) {
            sum += item;
        }

        return sum;
    }

    private static void printEvenOrOdd(List<Integer> list, String evenOrOdd) {
        for (Integer item : list) {
            if (evenOrOdd.equals("even")) {
                if (item % 2 == 0) {
                    System.out.printf("%d ", item);
                }
            } else {
                if (item % 2 == 1) {
                    System.out.printf("%d ", item);
                }
            }
        }
        System.out.println();
    }
}
