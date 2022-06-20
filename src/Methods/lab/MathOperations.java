package Methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        int b = Integer.parseInt(scanner.nextLine());

        double result = calculate(a, operator, b);
        System.out.println(new DecimalFormat("0.####").format(result));
    }

    private static double calculate(int first, char oper, int second) {
        double result = 0;
        switch (oper) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            case '/':
                result = 1.0 * first / second;
                break;
            default:
                break;
        }

        return result;
    }
}
