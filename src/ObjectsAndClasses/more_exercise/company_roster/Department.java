package ObjectsAndClasses.more_exercise.company_roster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Department {
    private String name;
    Employee employee;
    List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public double averageSalary() {
        double sum = 0;
        for (Employee employee : this.employees) {
            sum += employee.getSalary();
        }
        return sum / this.employees.size();
    }

    public void sortEmployeesBySalaryDescending() {
        this.employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
    }
    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.printf("%s %.2f %s %d%n",
                    employee.getName(),
                    employee.getSalary(),
                    employee.getEmail(),
                    employee.getAge());
        }
    }
}
