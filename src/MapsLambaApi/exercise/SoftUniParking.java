package MapsLambaApi.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");

            String command = inputArr[0];
            String name = inputArr[1];

            switch (command) {
                case "register":
                    String carNumber = inputArr[2];
                    if (!cars.containsKey(name)) {
                        cars.put(name, carNumber);
                        System.out.printf("%s registered %s successfully%n", name, carNumber);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", carNumber);
                    }
                    break;
                case "unregister":
                    if (cars.containsKey(name)) {
                        cars.remove(name);
                        System.out.printf("%s unregistered successfully%n", name);
                    }else {
                        System.out.printf("ERROR: user %s not found%n",name);
                    }
                    break;
            }
        }

        cars.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
