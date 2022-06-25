package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("end")) {
            if (input[0].equals("Insert")) {
                numbersList.add(Integer.parseInt(input[2]), Integer.parseInt(input[1]));
            } else if (input[0].equals("Delete")) {
                numbersList.removeAll(List.of(Integer.valueOf(input[1])));
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
