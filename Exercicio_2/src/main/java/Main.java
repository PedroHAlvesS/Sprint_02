import componente.GetNumberFromUser;
import componente.ShowMovies;
import dao.DB;
import dao.MovieDAO;
import domain.Movie;

import java.sql.Connection;
import java.util.ArrayList;


public class Main {

    public static String user = "";
    public static String password = "";
    public static void main(String[] args)  {

        int moviesByPage = GetNumberFromUser.getIntNumberBetween("Informe a quantidade de filmes por página: ", 0, 20);
        int page = GetNumberFromUser.getIntNumberBetween("Informe a página que você deseja ver: ", 1, 20);

        ArrayList<Movie> movies = new ArrayList<Movie>();

        // db session
        DB db = new DB(Main.user, Main.password);
        Connection connection = db.initConnection();
        try (connection) {
            movies = MovieDAO.pagination(connection, moviesByPage, page);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }

        // show db results
        if (movies.isEmpty()) {
            System.out.println("Não foi encontrado nenhum filme nesta busca!");
        } else {
            ShowMovies.showMovies(movies);
        }
    }
}
