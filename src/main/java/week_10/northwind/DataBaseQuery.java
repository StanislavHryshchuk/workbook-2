package week_10.northwind;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.Scanner;

public class DataBaseQuery {

    public static void displayAllProductsQuery(BasicDataSource dataSource){
        try (Connection connection =dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM products")) {
                try (ResultSet resultSet = ps.executeQuery()){
                    while (resultSet.next()) {
                        System.out.println(resultSet);
                    }
             }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayAllCustomersQuery(BasicDataSource dataSource){
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM customers \n" +
                     "ORDER BY Country")) {
            try (ResultSet resultSet = ps.executeQuery()){
                while (resultSet.next()) {
                    System.out.printf("""
                            -----------------
                            Company Name: %s
                            Contact Name: %s
                            City: %s
                            Country: %s
                            Phone: %s\n""",
                            resultSet.getString("CompanyName"),
                            resultSet.getString("ContactName"),
                            resultSet.getString("City"),
                            resultSet.getString("Country"),
                            resultSet.getString("Phone"));
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayAllCategoriesQuery(BasicDataSource dataSource){
        Scanner scanner = new Scanner(System.in);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT CategoryID, CategoryName FROM categories \n" +
                     "ORDER BY CategoryID")) {

            try (ResultSet resultSet = ps.executeQuery()){
                System.out.printf("%-20s %-20s\n", "Category ID", "Name");
                System.out.println("----------------------------------------");

                while (resultSet.next()) {
                    System.out.printf("%-20s %-20s\n",
                            resultSet.getString("CategoryID"),
                            resultSet.getString("CategoryName"));
                }
            }
            System.out.println("Please select the Category Id");
            int userCategoryId = Integer.parseInt(scanner.nextLine().trim());

            displayProductsByCategoryQuery(dataSource, userCategoryId);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayProductsByCategoryQuery(BasicDataSource dataSource, int userCategoryId){
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products \n" +
                             "Where CategoryID = ?;")) {
             ps.setInt(1,userCategoryId);

            try (ResultSet resultSet = ps.executeQuery()){
                while (resultSet.next()) {
                    System.out.printf("""
                            ---------------
                            Product ID: %d
                            Product Name: %s
                            Unit Price: $%.2f
                            Units in Stock: %d\n""",
                            resultSet.getInt("ProductID"),
                            resultSet.getString("ProductName"),
                            resultSet.getDouble("UnitPrice"),
                            resultSet.getInt("UnitsInStock"));
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Category Id");
        return Integer.parseInt(scanner.nextLine().trim());
    }

}
