package week_10.NorthwindShippers;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShippersDAO {

    private DataSource dataSource;

    public ShippersDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Shipper> getAll(){

        List<Shipper> shipperList = new ArrayList<>();
        String query = "SELECT * FROM shippers";

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet resultSet = ps.executeQuery()
        ){
            while (resultSet.next()){
                shipperList.add(new Shipper(
                        resultSet.getInt("ShipperID"),
                        resultSet.getString("CompanyName"),
                        resultSet.getString("Phone")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return shipperList;
    }

    public void add (Shipper shipper){
        String query = "INSERT INTO shippers (CompanyName, Phone) VALUES (?,?);";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
                ){
            ps.setString(1,shipper.getCompanyName());
            ps.setString(2,shipper.getPhone());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 1){
                throw new SQLException("Insertion failed" + shipper);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id,Shipper shipper){
        String query = "UPDATE shippers SET CompanyName = ?, Phone = ? \n" +
                        "WHERE ShipperID = ?";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ){
            ps.setString(1, shipper.getCompanyName());
            ps.setString(2, shipper.getPhone());
            ps.setInt(3, id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void delete(int id){
        String query = "DELETE FROM shippers WHERE ShipperID = ?;";
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

    public void printList(List<Shipper> shipperList){
        for(Shipper shipper: shipperList){
            System.out.println("Shipper ID: " + shipper.getShipperID());
            System.out.println(shipper.getCompanyName() + " - " + shipper.getPhone());
            System.out.println("--------------------");
        }
    }
}
