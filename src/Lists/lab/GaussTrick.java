package Lists.lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        int loops = numbers.size() / 2;

        for (int i = 0; i < loops; i++) {
            numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }

        String result = numbers.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        System.out.println(result);
    }
}
