package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureHunt {

    public static String[] LootItemsToChest(String[] currentChest, String[] newItems) {
        //check if every item is already present in chest
        int itemsForAdding = 0;
        for (int i = 0; i < newItems.length; i++) {
            boolean haveItem = false;
            for (String itemFromChest : currentChest) {
                if (newItems[i].equals(itemFromChest)) {
                    haveItem = true;
                    //delete item if present
                    newItems[i] = null;
                    break;
                }
            }
            if (!haveItem) {
                itemsForAdding++;
            }
        }

        if (itemsForAdding > 0) {
            //create the new bigger chest
            String[] newChest = new String[currentChest.length + itemsForAdding];
            //put the new items
            int positionInNewChest = 0;
            for (String item : newItems) {
                if (item != null) {
                    newChest[--itemsForAdding] = item;
                    positionInNewChest++;
                }
            }
            //copy the old chest after the new items
            for (int i = 0; i < currentChest.length; i++) {
                newChest[positionInNewChest++] = currentChest[i];
            }
            return newChest;
        } else {
            return currentChest;
        }
    }

    public static void DropItemToLastPosition(String[] currentChest, int index) {
        String tempItem = currentChest[index];

        for (int i = index; i < currentChest.length - 1; i++) {
            currentChest[i] = currentChest[i + 1];
        }

        currentChest[currentChest.length - 1] = tempItem;
    }

    public static String[] StealLastItemsFromChest(String[] currentChest, int numOfItems) {
        //make the last items equal to null
        for (int i = currentChest.length - 1; i > currentChest.length - 1 - numOfItems; i--) {
            currentChest[i] = null;
        }

        //create the new smaller chest
        String[] newChest = new String[currentChest.length - numOfItems];

        //copy the old chest without the nulls
        for (int i = 0; i < newChest.length; i++) {
            if (currentChest[i] != null) {
                newChest[i] = currentChest[i];
            }
        }
        return newChest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] chest = scanner.nextLine().split("\\|");
        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            String command = input.split(" ")[0];

            switch (command) {
                case "Loot":
                    String[] listOfItems = new String[input.split(" ").length - 1];

                    for (int i = 0; i < listOfItems.length; i++) {
                        listOfItems[i] = input.split(" ")[i + 1];
                    }

                    String[] newLootChest = LootItemsToChest(chest, listOfItems);
                    //replace the chest
                    chest = Arrays.copyOf(newLootChest, newLootChest.length);
                    break;

                case "Drop":
                    int indexToDrop = Integer.parseInt(input.split(" ")[1]);

                    //check if chest has the index
                    if (indexToDrop < chest.length && indexToDrop >= 0) {
                        DropItemToLastPosition(chest, indexToDrop);
                    }

                    break;

                case "Steal":
                    int itemsToSteal = Integer.parseInt(input.split(" ")[1]);
                    if (itemsToSteal > 0) {
                        //check if all will be stolen
                        if (itemsToSteal >= chest.length) {
                            //everything is stolen
                            String result = Arrays.toString(chest)
                                    .replace("[", "")
                                    .replace("]", "");
                            System.out.println(result);
                            String[] newEmptyChest = {null};
                            chest = Arrays.copyOf(newEmptyChest, newEmptyChest.length);
                        } else {
                            //steal last several items
                            String[] stolenItems = new String[itemsToSteal];
                            for (int i = 0; i < itemsToSteal; i++) {
                                stolenItems[i] = chest[chest.length - itemsToSteal + i];
                            }

                            String result = Arrays.toString(stolenItems)
                                    .replace("[", "")
                                    .replace("]", "");
                            System.out.println(result);

                            String[] newStealChest = StealLastItemsFromChest(chest, itemsToSteal);
                            //replace the chest
                            chest = Arrays.copyOf(newStealChest, newStealChest.length);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        if (chest.length > 0) {
            if (chest.length == 1 && chest[0] == null) {
                System.out.println("Failed treasure hunt.");
            } else {
                double sum = 0;
                for (String item : chest) {
                    sum += item.length();
                }
                double score = sum / chest.length;
                System.out.printf("Average treasure gain: %.2f pirate credits.", score);
            }
        }
    }
}
