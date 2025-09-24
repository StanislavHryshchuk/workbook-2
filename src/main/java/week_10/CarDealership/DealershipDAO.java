package week_10.CarDealership;
import week_10.NorthwindShippers.Shipper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealershipDAO {
    private static Scanner scanner = new Scanner(System.in);
    private DataSource dataSource;


    public DealershipDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Dealership> getAll(){

        List<Dealership> dealershipList = new ArrayList<>();
        String query = "SELECT * FROM dealerships";

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet resultSet = ps.executeQuery()
        ){
            while (resultSet.next()){
                dealershipList.add(new Dealership(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dealershipList;
    }

    public void add (Dealership dealership){
        String query = "INSERT INTO dealerships (name, address, phone) VALUES (?,?,?);";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setString(1,dealership.getName());
            ps.setString(2,dealership.getAddress());
            ps.setString(3,dealership.getPhone());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 1){
                throw new SQLException("Insertion failed" + dealership);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id,Dealership dealership){
        String query = "UPDATE dealerships SET name = ?, phone = ?, address = ? \n" +
                "WHERE id = ?";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ){
            ps.setString(1, dealership.getName());
            ps.setString(2, dealership.getPhone());
            ps.setString(3, dealership.getAddress());
            ps.setInt(4, id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void remove(int id){
        String query = "DELETE FROM dealerships WHERE id = ?;";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String add (){
        return "string";
    }
}