package Methods.lab;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());
        PrintGradeInWords(grade);
    }

    static void PrintGradeInWords(double gr) {
        if (gr <= 2.99){
            System.out.println("Fail");
        } else if (gr <= 3.49) {
            System.out.println("Poor");
        } else if (gr <= 4.49) {
            System.out.println("Good");
        } else if (gr <= 5.49) {
            System.out.println("Very good");
        } else if (gr <= 6.00) {
            System.out.println("Excellent");
        }
    }
}
