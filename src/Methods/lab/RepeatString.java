package Methods.lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int times = Integer.parseInt(scanner.nextLine());

        String result = repeatString(input, times);
        System.out.println(result);
    }

    private static String repeatString(String input, int times) {
        return String.valueOf(String.valueOf(input).repeat(Math.max(0, times)));
    }
}
