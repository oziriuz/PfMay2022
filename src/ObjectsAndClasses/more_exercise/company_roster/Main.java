package ObjectsAndClasses.more_exercise.company_roster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            String email = "n/a";
            int age = -1;

            if (input.length == 5) {
                if (input[4].contains("@")) {
                    email = input[4];
                } else {
                    age = Integer.parseInt(input[4]);
                }
            }

            if (input.length == 6) {
                email = input[4];
                age = Integer.parseInt(input[5]);
            }

            Employee employee = new Employee(name, salary, position, department, email, age);
            boolean isFoundDepartment = false;
            if (!departments.isEmpty()) {
                for (Department item : departments) {
                    if (item.getName().equals(employee.getDepartment())) {
                        item.addEmployee(employee);
                        isFoundDepartment = true;
                        break;
                    }
                }
            }

            if (departments.isEmpty() || !isFoundDepartment) {
                Department newDepartment = new Department(employee.getDepartment());
                departments.add(newDepartment);
                newDepartment.addEmployee(employee);
            }
        }

        double maxSalary = Double.MIN_VALUE;
        String maxSalaryDepartment = "";
        for (Department item : departments) {
            if (item.averageSalary() > maxSalary) {
                maxSalary = item.averageSalary();
                maxSalaryDepartment = item.getName();
            }
        }

        System.out.printf("Highest Average Salary: %s%n", maxSalaryDepartment);
        for (Department item : departments) {
            if (item.getName().equals(maxSalaryDepartment)) {
                item.sortEmployeesBySalaryDescending();
                item.printEmployees();
            }
        }
    }
}
