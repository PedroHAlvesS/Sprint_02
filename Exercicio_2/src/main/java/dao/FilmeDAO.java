package dao;

import domain.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO {
    public static ArrayList<Filme> paginacao(Connection connection, int quantidadeFilmes, int pagina){
        int offset = 0;
        int id;
        String nome;
        String descricao;
        int ano;

        ArrayList<Filme> filmes = new ArrayList<Filme>();
        offset = (pagina - 1) * quantidadeFilmes;

        String sql = "SELECT * FROM filme order by ID ASC LIMIT " + quantidadeFilmes + " OFFSET "+ offset;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
            try (ResultSet rst = preparedStatement.getResultSet() ){
                while (rst.next()) {
                    id = rst.getInt("ID");
                    nome = rst.getString("nome");
                    descricao = rst.getString("descrição");
                    ano = rst.getInt("ano");
                    Filme filmeTemp = new Filme(id, nome, descricao, ano);
                    filmes.add(filmeTemp);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
      }
        return filmes;
    }
}
