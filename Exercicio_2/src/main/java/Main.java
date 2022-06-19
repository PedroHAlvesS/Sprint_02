import dao.DB;
import dao.MovieDAO;
import domain.Movie;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)  {
        String user = "";
        String password = "";
        DB db = new DB(user, password);
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Connection connection = db.initConnection();
        try (connection) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Informe a quantidade de movies por página: ");
            int moviesByPage = Integer.parseInt(keyboard.nextLine());
            System.out.println("Informe a página: ");
            int page = Integer.parseInt(keyboard.nextLine());
            movies = MovieDAO.pagination(connection, moviesByPage, page);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        for (Movie movie : movies) {
            movie.showMovie();
        }

    }
}
