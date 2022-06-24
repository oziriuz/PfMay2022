package Methods.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] intArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("end")) {

            String com1 = command[0];
            String com2;
            int numberOfIndices;

            switch (com1) {
                case "exchange":
                    int position = Integer.parseInt(command[1]);
                    if (position >= intArray.length || position < 0) {
                        System.out.println("Invalid index");
                    } else {
                        splitAtIndexAndExchange(intArray, position);
                    }
                    break;
                case "max":
                    com2 = command[1];
                    printMaxEvenOrOddIndex(intArray, com2);
                    break;
                case "min":
                    com2 = command[1];
                    printMinEvenOrOddIndex(intArray, com2);
                    break;
                case "first":
                    numberOfIndices = Integer.parseInt(command[1]);
                    com2 = command[2];
                    if (numberOfIndices > intArray.length) {
                        System.out.println("Invalid count");
                    } else {
                        printFirstEvenOrOdd(intArray, numberOfIndices, com2);
                    }
                    break;
                case "last":
                    numberOfIndices = Integer.parseInt(command[1]);
                    com2 = command[2];
                    if (numberOfIndices > intArray.length) {
                        System.out.println("Invalid count");
                    } else {
                        printLastEvenOrOdd(intArray, numberOfIndices, com2);
                    }
                    break;
                default:
                    break;
            }

            command = scanner.nextLine().split(" ");
        }
        System.out.println(Arrays.toString(intArray));
    }

    private static int countEvenOrOdd(int[] arr, String evenOrOdd) {
        int evenCounter = 0;
        int oddCounter = 0;

        for (int number : arr) {
            if (number % 2 == 0) {
                evenCounter++;
            } else {
                oddCounter++;
            }
        }
        if (evenOrOdd.equals("even")) {
            return evenCounter;
        } else {
            return oddCounter;
        }
    }

    private static void printFirstEvenOrOdd(int[] arr, int indices, String evenOrOdd) {
        int allIndices = countEvenOrOdd(arr, evenOrOdd);
        int counter = 0;

        if (allIndices == 0) {
            System.out.println("[]");
            return;
        }

        if (allIndices < indices) {
            indices = allIndices;
        }

        int[] newArr = new int[indices];

        if (evenOrOdd.equals("even")) {
            for (int number : arr) {
                if (number % 2 == 0) {
                    if (counter < indices) {
                        newArr[counter++] = number;
                    } else {
                        break;
                    }
                }
            }
        } else if (evenOrOdd.equals("odd")) {
            for (int number : arr) {
                if (number % 2 == 1) {
                    if (counter < indices) {
                        newArr[counter++] = number;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(newArr));
    }

    private static void printLastEvenOrOdd(int[] arr, int indices, String evenOrOdd) {
        int allIndices = countEvenOrOdd(arr, evenOrOdd);

        if (allIndices == 0) {
            System.out.println("[]");
            return;
        }

        if (allIndices < indices) {
            indices = allIndices;
        }

        int[] newArr = new int[indices];

        if (evenOrOdd.equals("even")) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] % 2 == 0) {
                    if (indices > 0) {
                        newArr[--indices] = arr[i];
                    } else {
                        break;
                    }
                }
            }
        } else if (evenOrOdd.equals("odd")) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] % 2 == 1) {
                    if (indices > 0) {
                        newArr[--indices] = arr[i];
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(newArr));
    }

    private static void printMinEvenOrOddIndex(int[] arr, String evenOrOdd) {
        int smallest = Integer.MAX_VALUE;
        int minIndex = -1;

        if (evenOrOdd.equals("even")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    if (arr[i] <= smallest) {
                        smallest = arr[i];
                        minIndex = i;
                    }
                }
            }
        } else if (evenOrOdd.equals("odd")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 1) {
                    if (arr[i] <= smallest) {
                        smallest = arr[i];
                        minIndex = i;
                    }
                }
            }
        }

        if (minIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(minIndex);
        }
    }

    private static void printMaxEvenOrOddIndex(int[] arr, String evenOrOdd) {
        int biggest = Integer.MIN_VALUE;
        int maxIndex = -1;

        if (evenOrOdd.equals("even")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    if (arr[i] >= biggest) {
                        biggest = arr[i];
                        maxIndex = i;
                    }
                }
            }
        } else if (evenOrOdd.equals("odd")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 1) {
                    if (arr[i] >= biggest) {
                        biggest = arr[i];
                        maxIndex = i;
                    }
                }
            }
        }

        if (maxIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(maxIndex);
        }
    }

    private static void splitAtIndexAndExchange(int[] arr, int index) {
        int[] newArr = new int[arr.length];
        int counter = 0;
        for (int i = index + 1; i < arr.length; i++) {
            newArr[counter++] = arr[i];
        }

        for (int i = 0; i <= index; i++) {
            newArr[counter++] = arr[i];
        }

        System.arraycopy(newArr, 0, arr, 0, arr.length);
    }
}
