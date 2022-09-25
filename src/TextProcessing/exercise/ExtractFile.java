package TextProcessing.exercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        String[] folders = path.split("\\\\");

        String file = folders[folders.length - 1].split("\\.")[0];
        String extension = folders[folders.length - 1].split("\\.")[1];

        System.out.printf("File name: %s%n",file);
        System.out.printf("File extension: %s%n",extension);
    }
}
