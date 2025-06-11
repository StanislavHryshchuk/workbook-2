package week_10.DataManager;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class Main {
    public static SakilaDataManager dataManager;

    public static void main(String[] args) {

        init(args);

        List<Actor> actorList = dataManager.getActorByName();
        System.out.printf("%-20s %-20s %-20s\n", "Actor Id","First Name", "Last Name" );
        for (Actor actors: actorList){
            System.out.printf("%-20d %-20s %-20s\n", actors.getActorId() , actors.getFirstName(), actors.getLastName());
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
        dataManager = new SakilaDataManager(dataSource);
    }
}
