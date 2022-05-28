package BasicSyntax.exercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amountMoney = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double priceLightsaber = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());

        int numberOfLightSabers = (int) Math.ceil(studentsCount * 1.1);
        int numberOfBelts = studentsCount - studentsCount / 6;

        double totalCost = studentsCount * priceRobe + numberOfBelts * priceBelt + numberOfLightSabers * priceLightsaber;

        if (totalCost <= amountMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalCost);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalCost - amountMoney);
        }
    }
}
