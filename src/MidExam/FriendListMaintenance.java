package MidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FriendListMaintenance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> friendList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" +");

        List<String> blackList = new ArrayList<>();
        List<Integer> lostList = new ArrayList<>();

        while (!command[0].equals("Report")) {
            switch (command[0]) {
                case "Blacklist":
                    if (!friendList.contains(command[1])) {
                        System.out.printf("%s was not found.", command[1]);
                        System.out.println();
                    } else {
                        moveToBlacklist(command[1], friendList, blackList);
                        System.out.printf("%s was blacklisted.", command[1]);
                        System.out.println();
                    }
                    break;
                case "Error":
                    int index = Integer.parseInt(command[1]);
                    if (isValid(index, friendList)) {
                        String lostName = makeErrorLost(index, friendList, lostList);
                        if (lostName.length() > 0) {
                            System.out.printf("%s was lost due to an error.", lostName);
                            System.out.println();
                        }
                    }
                    break;
                case "Change":
                    int indexC = Integer.parseInt(command[1]);
                    String newName = command[2];
                    if (isValid(indexC, friendList)) {
                        String oldName = friendList.get(indexC);
                        friendList.set(indexC, newName);
                        System.out.printf("%s changed his username to %s.", oldName, newName);
                        System.out.println();
                    }
                    break;
                default:
                    break;
            }

            command = scanner.nextLine().split(" +");
        }

        System.out.printf("Blacklisted names: %d", blackList.size());
        System.out.println();
        System.out.printf("Lost names: %d", lostList.size());
        System.out.println();
        String resultString = friendList.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        System.out.println(resultString);
    }

    private static String makeErrorLost(int position, List<String> friends, List<Integer> lost) {
        String resultName = "";
        if (!friends.get(position).equals("Blacklisted") && !friends.get(position).equals("Lost")) {
            resultName = friends.get(position);
            friends.set(position, "Lost");
            lost.add(position);
        }
        return resultName;
    }

    private static boolean isValid(int i, List<String> list) {
        return i >= 0 && i < list.size();
    }

    private static void moveToBlacklist(String friend, List<String> friends, List<String> black) {
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).equals(friend)) {
                friends.set(i, "Blacklisted");
                black.add(friend);
            }
        }
    }
}
