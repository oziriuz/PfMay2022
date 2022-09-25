package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regEx1 = "^[$]([A-Z][a-z]{2,})[$][:][\\s][\\[]([0-9]+)[\\]][|][\\[]([0-9]+)[\\]][|][\\[]([0-9]+)[\\]][|]$";
        String regEx2 = "^[%]([A-Z][a-z]{2,})[%][:][\\s][\\[]([0-9]+)[\\]][|][\\[]([0-9]+)[\\]][|][\\[]([0-9]+)[\\]][|]$";

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (isValid(input, regEx1)) {
                decryptMessage(input, regEx1);
            } else if (isValid(input, regEx2)) {
                decryptMessage(input, regEx2);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }

    private static void decryptMessage(String input, String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);
        boolean result = matcher.find();
        String gr1 = matcher.group(1);
        int gr2 = Integer.parseInt(matcher.group(2));
        int gr3 = Integer.parseInt(matcher.group(3));
        int gr4 = Integer.parseInt(matcher.group(4));

        System.out.printf("%s: %s%s%s%n", gr1, (char)gr2, (char)gr3, (char)gr4);
    }

    public static boolean isValid(String input, String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);
        boolean result = matcher.find();
        return result;
    }
}
