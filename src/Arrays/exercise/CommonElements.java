package Arrays.exercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        for (String elementOfSecond: secondArray) {
            for (String elementOfFirst : firstArray) {
                if (elementOfSecond.equals(elementOfFirst)) {
                    System.out.print(elementOfSecond + " ");
                }
            }
        }
    }
}
