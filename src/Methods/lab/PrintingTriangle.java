package Methods.lab;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        printUpper(n);
        printMiddle(n);
        printLower(n);
    }

    private static void printUpper(int n) {
        for (int line = 1; line < n; line++) {
            for (int i = 1; i <= line; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void printMiddle(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printLower(int n) {
        for (int line = n-1; line >= 1; line--) {
            for (int i = 1; i <= line; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
