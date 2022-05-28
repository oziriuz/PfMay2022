package BasicSyntax.lab;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int newMinutes = hours * 60 + minutes + 30;

        hours = newMinutes / 60;
        minutes = newMinutes % 60;

        if (hours > 23) {
            hours -= 24;
        }

        System.out.printf("%d:%02d", hours, minutes);
    }
}
