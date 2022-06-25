package Lists.lab;

import java.util.*;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            products.add(scanner.nextLine());
        }

        products.sort(Comparator.naturalOrder());

        int number = 1;
        for (String product : products) {
            System.out.println(number++ + "." + product);
        }
    }
}
