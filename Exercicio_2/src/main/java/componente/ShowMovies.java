package componente;

import domain.Movie;

import java.util.ArrayList;

public abstract class ShowMovies {
    public static void showMovies(ArrayList<Movie> movies) {
        for (Movie movie : movies) {
            movie.showMovie();
        }
    }
}
