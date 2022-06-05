package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();

            int sum = 0;
            for (char letter : name.toCharArray()) {
                switch (letter) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        sum += letter * name.length();
                        break;
                    default:
                        sum += letter / name.length();
                        break;
                }
            }

            scores[i] = sum;
        }

        Arrays.sort(scores);

        for (int item : scores) {
            System.out.println(item);
        }

    }
}
