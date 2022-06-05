package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        int[] tempArray = new int[n];
        int maxSequenceOnesCounter = 0;
        int minIndexPosition = n;
        int maxProbeSum = 0;
        int bestProbeNumber = 1; //if all probes are the same, the best one is the first

        int probeCounter = 0;

        while (!input.equals("Clone them!")) {
            int[] dnaArray = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int tempSequenceOnesCounter = 0;
            int tempIndexPosition = n;
            int tempProbeSum = 0;

            probeCounter++;

            for (int item : dnaArray) {
                if (item == 1) {
                    tempProbeSum++;
                }
            }

            for (int i = 0; i < dnaArray.length - 1; i++) {
                if (dnaArray[i] == 1) {
                    int sequenceOnesCounter = 1;
                    for (int next = i + 1; next < dnaArray.length; next++) {
                        if (dnaArray[i] == dnaArray[next]) {
                            sequenceOnesCounter++;
                        } else {
                            break;
                        }
                    }

                    if (sequenceOnesCounter > tempSequenceOnesCounter) {
                        tempSequenceOnesCounter = sequenceOnesCounter;
                        tempIndexPosition = i;
                    }
                }
            }

            if (tempSequenceOnesCounter > maxSequenceOnesCounter) {
                maxSequenceOnesCounter = tempSequenceOnesCounter;
                minIndexPosition = tempIndexPosition;
                maxProbeSum = tempProbeSum;
                bestProbeNumber = probeCounter;
                tempArray = Arrays.copyOf(dnaArray, n);
            } else if (tempSequenceOnesCounter == maxSequenceOnesCounter) {
                if (tempIndexPosition < minIndexPosition) {
                    minIndexPosition = tempIndexPosition;
                    maxProbeSum = tempProbeSum;
                    bestProbeNumber = probeCounter;
                    tempArray = Arrays.copyOf(dnaArray, n);
                } else if (tempIndexPosition == minIndexPosition) {
                    if (tempProbeSum > maxProbeSum) {
                        maxProbeSum = tempProbeSum;
                        bestProbeNumber = probeCounter;
                        tempArray = Arrays.copyOf(dnaArray, n);
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestProbeNumber, maxProbeSum);
        System.out.println(Arrays.toString(tempArray)
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }
}
