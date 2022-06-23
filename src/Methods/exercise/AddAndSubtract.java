package Methods.exercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        int result = subtractThird(sumFirstTwo(first,  second), third);
        System.out.println(result);
    }

    private static int subtractThird(int n1, int n2) {
        return n1 - n2;
    }

    private static int sumFirstTwo(int n1, int n2) {
        return n1 + n2;
    }
}
