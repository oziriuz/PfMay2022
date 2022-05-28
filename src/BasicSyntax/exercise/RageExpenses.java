package BasicSyntax.exercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double priceHeadset = Double.parseDouble(scanner.nextLine());
        double priceMouse = Double.parseDouble(scanner.nextLine());
        double priceKeyboard = Double.parseDouble(scanner.nextLine());
        double priceDisplay = Double.parseDouble(scanner.nextLine());

        int headsets = lostGames / 2;
        int mice = lostGames / 3;
        int keyboards = lostGames / 6;
        int displays = lostGames / 12;

        double rageCost = headsets * priceHeadset + mice * priceMouse + keyboards * priceKeyboard + displays * priceDisplay;

        System.out.printf("Rage expenses: %.2f lv.", rageCost);
    }
}
