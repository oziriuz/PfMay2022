package MapsLambaApi.exercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] inputArr = input.split(" : ");
            String courseName = inputArr[0];
            String studentName = inputArr[1];

            List<String> studentList = new ArrayList<>();

            courses.putIfAbsent(courseName, studentList);
            courses.get(courseName).add(studentName);

            input = scanner.nextLine();
        }

        courses.forEach((key, value) -> {
            System.out.printf("%s: %d%n", key, value.size());
            value.forEach(student -> System.out.printf("-- %s%n", student));
        });
    }
}
