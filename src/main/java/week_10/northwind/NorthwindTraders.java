package week_10.northwind;

import org.apache.commons.dbcp2.BasicDataSource;

public class NorthwindTraders {

    public static void main(String[] args) {

        if (args.length != 2){
            System.out.println("Need 2 arguments");
        }

        String username = args[0];
        String password = args[1];

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");

        dataSource.setUsername(username);
        dataSource.setPassword(password);
        UserInterface.homeScreen(dataSource);
    }
}
