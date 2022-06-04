package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        boolean isBalanced = true;

        for (int i = 0; i < n; i++) {
            char symbol = scanner.nextLine().charAt(0);
            if (!isBalanced) {
                if (symbol == ')') {
                    isBalanced = true;
                }
                if (symbol == '(') {
                    break;
                }
            } else {
                if (symbol == '(') {
                    isBalanced = false;
                }
                if (symbol == ')') {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
