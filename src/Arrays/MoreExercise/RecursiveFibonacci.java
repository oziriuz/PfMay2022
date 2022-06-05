package Arrays.MoreExercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static int Fibonacci(int n) {
        if (n<=1) {
            return n;
        } else {
            return Fibonacci(n -1) + Fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(Fibonacci(n));
    }
}
