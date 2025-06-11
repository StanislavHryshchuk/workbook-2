package week_10.LanguageTask;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Optional;
import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static LanguageDao languageDaoDataManager;

    public static void HoneScreen(String[] args){
        init(args);
        boolean homeScreenRunning = true;
        try{
            while (homeScreenRunning){
                System.out.println("What would you like to do?");
                System.out.println("""
                        1. Get all languages.
                        2. Get languages by ID.
                        3. Get languages by Name.
                        4. Exit""");

                int userChoice = Integer.parseInt(scanner.nextLine().trim());

                switch (userChoice){
                    case 1 -> languageDaoDataManager.printList(languageDaoDataManager.getAllLanguages());
                    case 2 -> System.out.println(languageDaoDataManager.getLanguageById(PromptUtil.promptUserLanguageID()).orElseGet(() -> new Language(7, "Ukrainian")));
                    case 3 -> System.out.println(languageDaoDataManager.getLanguageByName(PromptUtil.promptUserLanguageName()));
                    case 4 -> {
                        System.out.println("Bye");
                        homeScreenRunning = false;
                    }
                    default -> System.out.println("Invalid input");
                }

            }
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }

    }
    public static void init(String[] args){
        if(args.length != 2){
            System.out.println("need 2 args");
        }

        String username = args[0];
        String password = args[1];

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource. setPassword(password);
        languageDaoDataManager = new LanguageDao(dataSource);
    }
}
