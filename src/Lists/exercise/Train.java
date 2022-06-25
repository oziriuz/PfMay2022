package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> train = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String[] input = scanner.nextLine().split(" ");
        int peopleToAdd = 0;
        while (!input[0].equals("end")) {

            if (input[0].equals("Add")) {
                train.add(Integer.valueOf(input[1]));
            } else {
                peopleToAdd = Integer.parseInt(input[0]);
                int wagonNumber = checkWagonForSpace(train, maxCapacity, peopleToAdd);
                if (wagonNumber >= 0) {
                    train.set(wagonNumber, train.get(wagonNumber) + peopleToAdd);
                }
            }
            input = scanner.nextLine().split(" ");
        }

        String newTrain = train.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");

        System.out.println(newTrain);
    }

    private static int checkWagonForSpace(List<Integer> list, int max, int add) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) + add <= max) {
                return i;
            }
        }
        return -1;
    }
}
