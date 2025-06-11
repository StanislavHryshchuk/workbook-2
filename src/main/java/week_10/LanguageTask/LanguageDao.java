package week_10.LanguageTask;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LanguageDao {
    private DataSource dataSource;

    public LanguageDao (DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Language> getAllLanguages(){
        List<Language> languageList = new ArrayList<>();

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(
                    "SELECT language_id, name FROM language");
                ResultSet resultSet = ps.executeQuery()
            ){
            while (resultSet.next()){
                languageList.add(new Language(resultSet.getInt("language_id"), resultSet.getString("name")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return languageList;
    }

    public Optional<Language>  getLanguageById(int id){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(
                        "SELECT language_id, name FROM language \n" +
                        "WHERE language_id = ?;")){
             ps.setInt(1,id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()){
                    return Optional.of(new Language( resultSet.getInt("language_id"), resultSet.getString("name")));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Language getLanguageByName(String name){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(
                        "SELECT language_id, name FROM language \n" +
                                "WHERE name = ?;")){
            ps.setString(1,name);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()){
                    return new Language(resultSet.getInt("language_id"), resultSet.getString("name"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public void printList(List<Language> languageList){
        for (Language language: languageList){
            System.out.printf("%s - %s\n", language.getId(), language.getName());
        }
    }
}
