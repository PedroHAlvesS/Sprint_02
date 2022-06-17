import dao.DB;
import dao.FilmeDAO;
import domain.Filme;

import java.sql.Connection;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args)  {
        String user = "";
        String password = "";
        DB db = new DB(user, password);
        ArrayList<Filme> filmes = new ArrayList<Filme>();
        Connection connection = db.initConnection();
        try (connection) {
            filmes = FilmeDAO.paginacao(connection, 5, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            filmes.get(i).mostrarFilme();
        }

    }
}
