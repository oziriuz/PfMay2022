package BasicSyntax.MoreExercises;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        double spentMoney = 0.0;

        String input = scanner.nextLine();

        while (!input.equals("Game Time")) {


            double price = 0.0;

            switch (input) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                default:
                    input = "Not Found";
                    break;
            }
            if (!input.equals("Not Found")) {
                if (price > currentBalance) {
                    System.out.println("Too Expensive");
                } else {
                    System.out.printf("Bought %s%n", input);
                    currentBalance -= price;
                    spentMoney += price;
                }
            } else {
                System.out.println(input);
            }

            if (currentBalance <= 0) {
                System.out.println("Out of money!");
                return;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spentMoney, currentBalance);
    }
}
