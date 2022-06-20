package Methods.lab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String variables = scanner.nextLine();

        String first = scanner.nextLine();
        String second = scanner.nextLine();

        switch (variables) {
            case "int":
                int varInt1 = Integer.parseInt(first);
                int varInt2 = Integer.parseInt(second);
                int resultInt = getMax(varInt1, varInt2);
                System.out.println(resultInt);
                break;
            case "char":
                char varChar1 = first.charAt(0);
                char varChar2 = second.charAt(0);
                char resultChar = getMax(varChar1, varChar2);
                System.out.println(resultChar);
                break;
            case "string":
                String resultString = getMax(first, second);
                System.out.println(resultString);
                break;
            default:
                break;
        }
    }

    private static int getMax(int var1, int var2) {
        return Math.max(var1, var2);
    }

    private static char getMax(char var1, char var2) {
        if (var1 > var2) {
            return var1;
        } else {
            return var2;
        }
    }

    private static String getMax(String var1, String var2) {
        if (var1.compareTo(var2) >= 0) {
            return var1;
        } else {
            return var2;
        }
    }
}
