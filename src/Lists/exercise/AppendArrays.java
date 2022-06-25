package Lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listOfLists = Arrays.stream(scanner.nextLine()
                        .split("\\|+"))
                .collect(Collectors.toList());

        List<Integer> numbersList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        for (String list : listOfLists) {
            if (list.trim().length() > 0) {
                numbersList = Arrays.stream(list.trim().split(" +"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                resultList.addAll(0, numbersList);
                numbersList.clear();
            }
        }

        String resultString = resultList.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        System.out.println(resultString);
    }
}
