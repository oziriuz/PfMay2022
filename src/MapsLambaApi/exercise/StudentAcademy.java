package MapsLambaApi.exercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> gradesMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double currentGrade = Double.parseDouble(scanner.nextLine());

            gradesMap.putIfAbsent(studentName, new ArrayList<>());
            gradesMap.get(studentName).add(currentGrade);
        }

        for (Map.Entry<String, List<Double>> entry : gradesMap.entrySet()) {
            double sum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
            }
            double average = sum / entry.getValue().size();
            if (average >= 4.5) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), average);
            }
        }
    }
}
