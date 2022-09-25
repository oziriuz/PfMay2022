package RegularExpressions.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "%([A-Z][a-z]+)%[^|$%.]*<(\\w+)>[^|$%.]*\\|(\\d+)\\|[^|$%.0-9]*([0-9]+.?[\\d]*)\\$";
        Pattern pattern = Pattern.compile(regex);
        double totalIncome = 0.0;

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String customer = matcher.group(1);
                String product = matcher.group(2);
                int quantity = Integer.parseInt(matcher.group(3));
                double price = Double.parseDouble(matcher.group(4));

                System.out.printf("%s: %s - %.2f%n", customer, product, quantity * price);
                totalIncome += quantity * price;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f%n",totalIncome);
    }
}
