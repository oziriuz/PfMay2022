package ObjectsAndClasses.exercise.order_by_age;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String[] input = scanner.nextLine().split(" ");
        while (!input[0].equals("End")) {
            String name = input[0];
            String id = input[1];
            int age = Integer.parseInt(input[2]);
            Person person = new Person(name, id, age);
            people.add(person);

            input = scanner.nextLine().split(" ");
        }

        people.sort(Comparator.comparingInt(Person::getAge));

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
