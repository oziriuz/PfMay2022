package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> bombData = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int bombNumber = bombData.get(0);
        int bombPower = bombData.get(1);

        int bombIndex = getPlaceForBomb(numbersList, bombNumber);

        while (bombIndex >= 0) {
            int start = validSublistStart(bombIndex, bombPower);
            int stop = validSublistStop(bombIndex, bombPower, numbersList.size());
            numbersList.subList(start, stop + 1).clear();
            bombIndex = getPlaceForBomb(numbersList, bombNumber);
        }

        System.out.println(sumOfNumberInList(numbersList));
    }

    private static int sumOfNumberInList(List<Integer> list) {
        int sum = 0;
        for (Integer item : list) {
            sum += item;
        }

        return sum;
    }

    private static int validSublistStop(int index, int power, int size) {
        if (index + power > size - 1) {
            return size - 1;
        } else {
            return index + power;
        }
    }

    private static int validSublistStart(int index, int power) {
        if (index - power < 0) {
            return 0;
        } else {
            return index - power;
        }
    }

    private static int getPlaceForBomb(List<Integer> list, int number) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == number) {
                return i;
            }
        }
        return -1;
    }
}
