package MapsLambaApi.exercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companyUsers = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String company = input.split(" -> ")[0];
            String employeeId = input.split(" -> ")[1];

            companyUsers.putIfAbsent(company, new ArrayList<>());
            if (!companyUsers.get(company).contains(employeeId)) {
                companyUsers.get(company).add(employeeId);
            }
            input = scanner.nextLine();
        }

        companyUsers.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(user -> System.out.printf("-- %s%n", user));
        });
    }
}
