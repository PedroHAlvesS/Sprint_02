package dao;

import domain.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDAO {
    public static ArrayList<Movie> pagination(Connection connection, int moviesByPage, int page){
        int offset = 0;
        int id;
        String name;
        String description;
        int year;

        ArrayList<Movie> movies = new ArrayList<Movie>();
        offset = (page - 1) * moviesByPage;

        String sql = "SELECT * FROM filme order by ID ASC LIMIT " + moviesByPage + " OFFSET "+ offset;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
            try (ResultSet rst = preparedStatement.getResultSet() ){
                while (rst.next()) {
                    id = rst.getInt("ID");
                    name = rst.getString("nome");
                    description = rst.getString("descrição");
                    year = rst.getInt("ano");
                    Movie movieTemp = new Movie(id, name, description, year);
                    movies.add(movieTemp);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
      }
        return movies;
    }
}
