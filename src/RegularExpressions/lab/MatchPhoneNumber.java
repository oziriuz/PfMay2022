package RegularExpressions.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\+359([ -])2(?:\\1)\\d{3}(?:\\1)\\d{4}\\b");
        Matcher matcher = pattern.matcher(input);
        List<String> phoneList;
        phoneList = new ArrayList<>();

        while (matcher.find()) {
            String phoneNumber = matcher.group();
            phoneList.add(phoneNumber);
        }

        System.out.println(String.join(", ",phoneList));
    }
}
