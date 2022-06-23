package Methods.exercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        int smallest = smallerNumber(first,second);
        smallest = smallerNumber(smallest, third);

        System.out.println(smallest);
    }

    private static int smallerNumber(int n1, int n2) {
        if (n1 < n2) {
            return n1;
        } else {
            return n2;
        }
    }
}
