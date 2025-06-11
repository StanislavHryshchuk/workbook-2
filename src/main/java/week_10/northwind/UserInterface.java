package week_10.northwind;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;

public class UserInterface {

    public static void homeScreen(BasicDataSource dataSource) {

        Scanner scanner = new Scanner(System.in);
        boolean homeScreenRunning = true;
        try {
            while (homeScreenRunning) {
                System.out.println("Please select an option");
                System.out.println("""
                        1. Display all products.
                        2. Display all Customers.
                        3. Display all categories.
                        4. Exit""");

                int userInput = Integer.parseInt(scanner.nextLine().trim());
                switch (userInput) {
                    case 1 -> DataBaseQuery.displayAllProductsQuery(dataSource);
                    case 2 -> DataBaseQuery.displayAllCustomersQuery(dataSource);
                    case 3 -> DataBaseQuery.displayAllCategoriesQuery(dataSource);
                    case 4 -> homeScreenRunning = false;
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
}
