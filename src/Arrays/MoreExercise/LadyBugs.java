package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        int[] indexWithBug = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] fieldWithBugs = new int[fieldSize];

        validateAndPutBugsInField(indexWithBug, fieldWithBugs);

        String input = scanner.nextLine();

        while (!input.equals("end")){
            int bugToMove = Integer.parseInt(input.split(" ")[0]);
            String direction = input.split(" ")[1];
            int distance = Integer.parseInt(input.split(" ")[2]);

            if (direction.equals("left") && distance > 0) {
                checkIfNotEmptyAndMoveLeft(fieldWithBugs, bugToMove, distance);
            } else if (direction.equals("right") && distance > 0) {
                checkIfNotEmptyAndMoveRight(fieldWithBugs, bugToMove, distance);
            }

            input = scanner.nextLine();
        }

        String result = Arrays.toString(fieldWithBugs)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");

        System.out.println(result);
    }

    public static void validateAndPutBugsInField(int[] bugNumbers, int[] field) {
        for (int bugIndex : bugNumbers) {
            if (bugIndex < field.length && bugIndex >= 0) {
                field[bugIndex] = 1;
            }
        }
    }

    public static void checkIfNotEmptyAndMoveLeft(int[] field, int bugNumber, int distanceToGo) {
        if (bugNumber < field.length && bugNumber >= 0) {
            //check for bug
            if (field[bugNumber] == 1) {
                //remove bug
                field[bugNumber] = 0;
                int positionToGo = bugNumber - distanceToGo;

                //if position do not exist - fly away;
                if (positionToGo < 0 || positionToGo >= field.length) {
                    return;
                }

                //check if position to go is not empty
                while (positionToGo >= 0) {
                    if (field[positionToGo] == 1) {
                        //move to next left
                        positionToGo-=distanceToGo;
                    } else {
                        field[positionToGo] = 1;
                        return;
                    }
                }
            }
        }
    }

    public static void checkIfNotEmptyAndMoveRight(int[] field, int bugNumber, int distanceToGo) {
        if (bugNumber < field.length && bugNumber >= 0) {
            //check for bug
            if (field[bugNumber] == 1) {
                //remove bug
                field[bugNumber] = 0;
                int positionToGo = bugNumber + distanceToGo;

                //if position do not exist - fly away;
                if (positionToGo < 0 || positionToGo >= field.length) {
                    return;
                }

                //check if position to go is not empty
                while (positionToGo < field.length) {
                    //if busy
                    if (field[positionToGo] == 1) {
                        //move to next left
                        positionToGo+=distanceToGo;
                    } else {
                        field[positionToGo] = 1;
                        return;
                    }
                }
            }
        }
    }
}
