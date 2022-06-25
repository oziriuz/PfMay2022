package Lists.lab;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> firstGroup = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        List<Double> secondGroup = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        List<Double> resultGroup = new ArrayList<>();

        int smallerListSize = 0;
        boolean isFirstSmaller = true;

        if (firstGroup.size() < secondGroup.size()) {
            smallerListSize = firstGroup.size();
        } else {
            smallerListSize = secondGroup.size();
            isFirstSmaller = false;
        }

        for (int i = 0; i < smallerListSize; i++) {
            resultGroup.add(firstGroup.get(i));
            resultGroup.add(secondGroup.get(i));
        }

        if (isFirstSmaller) {
            for (int i = smallerListSize; i < secondGroup.size(); i++) {
                resultGroup.add(secondGroup.get(i));
            }
        } else {
            for (int i = smallerListSize; i < firstGroup.size(); i++) {
                resultGroup.add(firstGroup.get(i));
            }
        }

        String result = resultGroup.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        System.out.println(result);
    }
}
