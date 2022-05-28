package BasicSyntax.exercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double coinSum = 0;
        while (!input.equals("Start")) {

            double coinInsert = Double.parseDouble(input);
            if (coinInsert == 0.1 || coinInsert == 0.2 ||
                    coinInsert == 0.5 || coinInsert == 1.0 ||
                    coinInsert == 2.0) {
                coinSum += coinInsert;
            } else {
                System.out.printf("Cannot accept %.2f%n", coinInsert);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {

            double price = 0.00;
            String product = input;

            switch (input) {
                case "Nuts":
                    price = 2.00;
                    break;
                case "Water":
                    price = 0.70;
                    break;
                case "Crisps":
                    price = 1.50;
                    break;
                case "Soda":
                    price = 0.80;
                    break;
                case "Coke":
                    price = 1.00;
                    break;
                default:
                    product = "Invalid product";
                    System.out.println(product);
            }

            if (!product.equals("Invalid product")) {
                if (coinSum >= price) {
                    System.out.printf("Purchased %s%n", product);
                    coinSum -= price;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            }
            input = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", coinSum);
    }
}
