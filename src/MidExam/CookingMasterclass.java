package MidExam;

import java.util.Scanner;

public class CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        double priceFlour = Double.parseDouble(scanner.nextLine());
        double priceEgg = Double.parseDouble(scanner.nextLine());
        double priceApron = Double.parseDouble(scanner.nextLine());

        int numForFlour = numberOfStudents - (numberOfStudents / 5);
        double costOfFlours = numForFlour * priceFlour;
        double costOfEggs = numberOfStudents * priceEgg * 10;
        double costOfAprons = Math.ceil(numberOfStudents * 1.2) * priceApron;

        double totalCost = costOfAprons + costOfEggs + costOfFlours;

        if (budget >= totalCost) {
            System.out.printf("Items purchased for %.2f$.", totalCost);
        } else {
            System.out.printf("%.2f$ more needed.", totalCost - budget);
        }
    }
}
