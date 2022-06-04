package DataTypesAndVariables.lab;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int meterInput = Integer.parseInt(scanner.nextLine());

        double kilometersOutput = meterInput / 1000.0;

        System.out.printf("%.2f", kilometersOutput);
    }
}
