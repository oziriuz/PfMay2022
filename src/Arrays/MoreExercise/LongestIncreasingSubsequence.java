package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr.length;
        lis(arr, n);
    }

    static void lis(int[] arr, int n) {
        int[] len = new int[n];
        int[] prev = new int[n];
        int maxLen = 0;
        int position = 0;

        for (int i = 0; i < n; i++) {
            len[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    prev[i] = j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (len[i] == 1) {
                prev[i] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (maxLen < len[i]) {
                maxLen = len[i];
                position = i;
            }
        }

        int[] result = new int[maxLen];
        int k = maxLen;
        while (position >= 0) {
            result[--k] = arr[position];
            position = prev[position];

        }

        System.out.println(Arrays.toString(result)
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }
}
