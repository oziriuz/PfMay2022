package MapsLambaApi.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, double[]> orders = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] inputArr = input.split(" ");
            String product = inputArr[0];
            double price = Double.parseDouble(inputArr[1]);
            double quantity = Double.parseDouble(inputArr[2]);
            double[] totalPriceArr = new double[]{0, 0};

            orders.putIfAbsent(product, totalPriceArr);

            orders.get(product)[0] = price;
            double currentQuantity = orders.get(product)[1];
            orders.get(product)[1] = currentQuantity + quantity;

            input = scanner.nextLine();
        }

        orders.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value[0] * value[1]));
    }
}
