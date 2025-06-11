package week_10;
import java.sql.*;
import java.util.Scanner;

public class ConnectingDB {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Need 2 arguments to work");
        }

        String username = args[0];
        String password = args[1];
        String url = "jdbc:mysql://localhost:3306/northwind";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT ProductName, UnitPrice, CategoryName FROM categories AS c\n" +
                     " JOIN products AS p ON c.CategoryID = p.CategoryID\n" +
                     " WHERE CategoryName = ?\n" +
                     " ORDER BY UnitPrice DESC\n" +
                     " LIMIT 5")) {
            ps.setString(1,  getUserInput());
            try (ResultSet resultSet = ps.executeQuery()){
                while (resultSet.next()){
                    System.out.println("Category Name: " + resultSet.getString("CategoryName"));
                    System.out.printf("""
                        Product Name: %s
                        Price: $%.2f
                        """, resultSet.getString("ProductName"), resultSet.getDouble("UnitPrice"));
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String getUserInput(){
        System.out.println("Please enter the category name");
        return scanner.nextLine().trim();
    }
}

