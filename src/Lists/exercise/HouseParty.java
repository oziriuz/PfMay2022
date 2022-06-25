package Lists.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> partyMembers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            String name = command[0];
            boolean isGoing = !command[2].equals("not");

            if (isGoing) {
                if (!partyMembers.contains(name)) {
                    partyMembers.add(name);
                } else {
                    System.out.printf("%s is already in the list!", name);
                    System.out.println();
                }
            } else {
                if (partyMembers.contains(name)) {
                    partyMembers.remove(name);
                } else {
                    System.out.printf("%s is not in the list!", name);
                    System.out.println();
                }
            }
        }

        for (String member : partyMembers) {
            System.out.println(member);
        }
    }
}
