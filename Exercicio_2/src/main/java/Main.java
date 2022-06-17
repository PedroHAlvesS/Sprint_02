import dao.DB;
import dao.FilmeDAO;
import domain.Filme;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)  {
        String user = "";
        String password = "";
        DB db = new DB(user, password);
        ArrayList<Filme> filmes = new ArrayList<Filme>();
        Connection connection = db.initConnection();
        try (connection) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Informe a quantidade de filmes por página: ");
            int quantidadeFilmes = Integer.parseInt(teclado.nextLine());
            System.out.println("Informe a página: ");
            int pagina = Integer.parseInt(teclado.nextLine());
            filmes = FilmeDAO.paginacao(connection, quantidadeFilmes, pagina);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            filmes.get(i).mostrarFilme();
        }

    }
}
