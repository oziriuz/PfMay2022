package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] bigArray = new int[n][];

        for (int i = 0; i < n; i++) {
            int[] row = new int[i + 1];

            row[0] = 1;
            row[row.length - 1] = 1;
            bigArray[i] = row;

            if (row.length > 2) {
                for (int element = 1; element < row.length - 1; element++) {
                    row[element] = bigArray[i - 1][element-1] + bigArray[i - 1][element];
                }
            }

            String result = Arrays.toString(row)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "");
            System.out.println(result);
        }
    }
}
