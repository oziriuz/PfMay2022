package Lists.lab;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(numbersList);

        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) < 0) {
                numbersList.remove(i--);
            }
        }

        if (numbersList.size() > 0) {
            String resultString = numbersList.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "");

            System.out.println(resultString);
        } else {
            System.out.println("empty");
        }
    }
}
