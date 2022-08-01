package MapsLambaApi.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> pointsMap = new LinkedHashMap<>();
        Map<String, Integer> submissionsMap = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {
            String[] inputArr = input.split("-");
            String username = inputArr[0];
            String language = inputArr[1];
            if (!language.equals("banned")) {
                int points = Integer.parseInt(inputArr[2]);

                pointsMap.putIfAbsent(username, 0);
                int currentPoints = pointsMap.get(username);
                if (currentPoints < points) {
                    pointsMap.put(username, points);
                }

                submissionsMap.putIfAbsent(language, 0);
                int currentValue = submissionsMap.get(language);
                submissionsMap.put(language, currentValue + 1);

            } else {
                pointsMap.remove(username);
                input = scanner.nextLine();
                continue;
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");
        pointsMap.forEach((key, value) -> System.out.println(key + " | " + value));
        System.out.println("Submissions:");
        submissionsMap.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
