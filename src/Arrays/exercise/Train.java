package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagons = Integer.parseInt(scanner.nextLine());

        int [] people = new int[wagons];
        int sum = 0;

        for (int i = 0; i < wagons; i++) {
            people[i] = Integer.parseInt(scanner.nextLine());
            sum += people[i];
        }

        String result = Arrays.toString(people)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        System.out.println(result);
        System.out.println(sum);
    }
}
