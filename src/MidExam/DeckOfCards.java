package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeckOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> deckOfCards = Arrays.stream(scanner.nextLine().split(", +"))
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(", +");
            switch (command[0]) {
                case "Add":
                    if (!deckOfCards.contains(command[1])) {
                        deckOfCards.add(command[1]);
                        System.out.println("Card successfully added");
                    } else {
                        System.out.println("Card is already in the deck");
                    }
                    break;
                case "Remove":
                    if (deckOfCards.contains(command[1])) {
                        deckOfCards.remove(command[1]);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Card not found");
                    }
                    break;
                case "Remove At":
                    int index = Integer.parseInt(command[1]);
                    if (isValid(index, deckOfCards)) {
                        deckOfCards.remove(index);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
                case "Insert":
                    int indexI = Integer.parseInt(command[1]);
                    String cardName = command[2];
                    if (isValid(indexI, deckOfCards)) {
                        if (!deckOfCards.contains(cardName)) {
                            deckOfCards.add(indexI, cardName);
                            System.out.println("Card successfully added");
                        } else {
                            System.out.println("Card is already added");
                        }
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
                default:
                    break;
            }
        }

        String resultString = deckOfCards.toString()
                .replace("[", "")
                .replace("]", "");
        System.out.println(resultString);

    }

    private static boolean isValid(int i, List<String> list) {
        return i >= 0 && i < list.size();
    }
}
