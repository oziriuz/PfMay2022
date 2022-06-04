package Arrays.lab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] daysOfWeek = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        int n = Integer.parseInt(scanner.nextLine());

        if (n >= 1 && n <= 7) {
            System.out.println(daysOfWeek[n - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
