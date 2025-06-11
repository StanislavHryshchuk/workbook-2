package week_10.LanguageTask;

import java.util.Scanner;

public class PromptUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int promptUserLanguageID(){
        System.out.println("Please enter the language ID");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public static String promptUserLanguageName(){
        System.out.println("Please enter the Language name");
        return scanner.nextLine().trim();
    }
}
