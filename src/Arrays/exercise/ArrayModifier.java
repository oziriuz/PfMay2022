package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String command = input.split(" ")[0];


            switch (command) {
                case "swap":
                    int firstSwap = Integer.parseInt(input.split(" ")[1]);
                    int secondSwap = Integer.parseInt(input.split(" ")[2]);
                    int tempSwap = numbers[firstSwap];
                    numbers[firstSwap] = numbers[secondSwap];
                    numbers[secondSwap] = tempSwap;
                    break;
                case "multiply":
                    int firstMultiplier = Integer.parseInt(input.split(" ")[1]);
                    int secondMultiplier = Integer.parseInt(input.split(" ")[2]);
                    int tempProduct = numbers[firstMultiplier] * numbers[secondMultiplier];
                    numbers[firstMultiplier] = tempProduct;
                    break;
                case "decrease":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i]--;
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        String result = Arrays.toString(numbers)
                .replace("[", "")
                .replace("]", "");

        System.out.println(result);
    }
}
