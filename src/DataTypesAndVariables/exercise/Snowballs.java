package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long maxValue = Long.MIN_VALUE;
        String result = "";

        for (int i = 0; i < n; i++) {
            int snow = Integer.parseInt(scanner.nextLine());
            int time = Integer.parseInt(scanner.nextLine());
            int quality = Integer.parseInt(scanner.nextLine());

            int temp = snow / time;
            long value = (long) Math.pow(temp, quality);
            if (value > maxValue) {
                maxValue = value;
                result = String.format("%d : %d = %d (%d)", snow, time, value, quality);
            }
        }
        System.out.println(result);
    }
}
