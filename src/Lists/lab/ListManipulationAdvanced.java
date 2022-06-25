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
                    System.out.println(numbers.contains(Integer.parseInt(input[1])));
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

                    break;
                default:
                    break;
            }
        }
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
    }
}
