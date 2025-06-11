package week_10.DataManager;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SakilaDataManager {
    private DataSource dataSource;

    public SakilaDataManager(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Actor> getAllActors(){
        List<Actor> actorList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "Select actor_id, first_name,last_name FROM actor");
             ResultSet resultSet = ps.executeQuery()){

            while (resultSet.next()){
                Actor actor = new Actor(
                        resultSet.getInt("actor_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"));
                actorList.add(actor);

                System.out.printf("%-20s %-20s %-20s\n", "Actor Id","First Name", "Last Name" );
                for (Actor actors: actorList){
                    System.out.printf("%-20d %-20s %-20s\n", actors.getActorId() , actors.getFirstName(), actors.getLastName());
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return actorList;
    }

    public List<Actor> getActorByName(){
        List<Actor> actorList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT actor_id, first_name,last_name FROM actor \n" +
                             "WHERE first_name = ? AND last_name = ?;")){
            Actor searchActor = promptUserActorName();
            ps.setString(1,searchActor.getFirstName());
            ps.setString(2,searchActor.getLastName());

            try (ResultSet resultSet = ps.executeQuery()){
                while (resultSet.next()){

                    actorList.add(new Actor(
                            resultSet.getInt("actor_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name")));
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return actorList;
    }

    public Actor promptUserActorName(){
        Actor actor = new Actor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name of actor");
        actor.setFirstName(scanner.nextLine().trim());
        System.out.println("Enter Last name of actor");
        actor.setLastName(scanner.nextLine().trim());
        return actor;
    }
}
