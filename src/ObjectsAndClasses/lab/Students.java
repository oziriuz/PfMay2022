package ObjectsAndClasses.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String homeTown;

        public Student(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }

        public String getHomeTown() {
            return homeTown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Student> studentList = new ArrayList<>();
        while (!input.equals("end")) {
            String[] inputArr = input.split(" ");
            String inputFirstName = inputArr[0];
            String inputLastName = inputArr[1];
            int inputAge = Integer.parseInt(inputArr[2]);
            String inputHomeTown = inputArr[3];

            if (studentExists(studentList, inputFirstName, inputLastName)) {
                Student student = getStudent(studentList, inputFirstName, inputLastName);

                student.setAge(inputAge);
                student.setHomeTown(inputHomeTown);
            } else {
                Student student = new Student(inputFirstName, inputLastName, inputAge, inputHomeTown);
                studentList.add(student);
            }
            input = scanner.nextLine();
        }

        String filterTown = scanner.nextLine();

        for (Student student : studentList) {
            if (student.getHomeTown().equals(filterTown)) {
                System.out.printf("%s %s is %d years old%n",
                        student.getFirstName(),
                        student.getLastName(),
                        student.getAge());
            }
        }
    }

    public static boolean studentExists(List<Student> students, String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }

        return false;
    }

    public static Student getStudent (List<Student> students, String firstName, String lastName) {
        Student existingStudent = null;

        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }

        return existingStudent;
    }
}
