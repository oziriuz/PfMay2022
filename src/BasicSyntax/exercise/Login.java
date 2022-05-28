package BasicSyntax.exercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();
        String password = scanner.nextLine();

        String realPassword = "";

        for (int i = userName.length()-1; i >= 0; i--) {
            realPassword += userName.charAt(i);
        }

        int tries = 1;
        while (!password.equals(realPassword)) {
            System.out.println("Incorrect password. Try again.");
            tries++;

            password = scanner.nextLine();

            if (tries >= 4) {
                break;
            }
        }

        if (password.equals(realPassword)) {
            System.out.printf("User %s logged in.", userName);
        } else {
            System.out.printf("User %s blocked!", userName);
        }
    }
}
