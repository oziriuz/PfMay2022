package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> deck1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> deck2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int cycles = Math.min(deck1.size(), deck2.size());

        while (cycles > 0) {
            if (deck1.get(0) > deck2.get(0)) {
                deck1.add(deck1.get(0));
                deck1.add(deck2.get(0));
                deck1.remove(0);
                deck2.remove(0);
            } else if (deck1.get(0) < deck2.get(0)) {
                deck2.add(deck2.get(0));
                deck2.add(deck1.get(0));
                deck2.remove(0);
                deck1.remove(0);
            } else {
                deck1.remove(0);
                deck2.remove(0);
            }
            cycles = Math.min(deck1.size(), deck2.size());
        }
        if (deck1.size() > 0) {
            System.out.println("First player wins! Sum: " + sumOfNumberInList(deck1));
        } else {
            System.out.println("Second player wins! Sum: " + sumOfNumberInList(deck2));
        }
    }

    private static int sumOfNumberInList(List<Integer> list) {
        int sum = 0;
        for (Integer item : list) {
            sum += item;
        }

        return sum;
    }
}
