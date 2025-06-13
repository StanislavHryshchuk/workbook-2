package week_10.CarDealership;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    private DataSource dataSource;

    public VehicleDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public List<Vehicle> getAll(){

        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT * FROM dealerships";

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet resultSet = ps.executeQuery()
        ){
            while (resultSet.next()){
                vehicleList.add(new Vehicle(resultSet.getInt("dealershipID"),
                        resultSet.getInt("id"),
                        resultSet.getString("VIN"),
                        resultSet.getString("make"),
                        resultSet.getString("model"),
                        resultSet.getInt("year"),
                        resultSet.getString("type"),
                        resultSet.getString("color"),
                        resultSet.getInt("odometer"),
                        resultSet.getDouble("price"),
                        resultSet.getBoolean("sold")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return vehicleList;
    }

    public void add (Vehicle vehicle){
        String query = "INSERT INTO vehicles (dealershipID, VIN, make, model, year,type,color,odometer,price,sold) VALUES (?,?,?,?,?,?,?,?,?,?);";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ){
            ps.setInt(1,vehicle.getDealershipID());
            ps.setString(2,vehicle.getVIN());
            ps.setString(3,vehicle.getMake());
            ps.setString(4,vehicle.getModel());
            ps.setInt(5,vehicle.getYear());
            ps.setString(6,vehicle.getType());
            ps.setString(7,vehicle.getColor());
            ps.setInt(8,vehicle.getOdometer());
            ps.setDouble(9,vehicle.getPrice());
            ps.setBoolean(10,vehicle.isSold());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 1){
                throw new SQLException("Insertion failed" + vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePrice(int id, double price){
        String query = "UPDATE vehicles SET price = ? \n" +
                "WHERE id = ?";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ){
            ps.setDouble(1, price);
            ps.setDouble(2, id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void updateSold(Vehicle vehicle){
        String query = "UPDATE vehicles SET price = ? \n" +
                "WHERE id = ?";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ){
            ps.setBoolean(1, vehicle.isSold());
            ps.setInt(2, vehicle.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void remove(int id){
        String query = "DELETE FROM vehicles WHERE id = ?;";
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


}
