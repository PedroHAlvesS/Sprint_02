package dao;

import domain.Produto;
import exceptions.MineExceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    public static void inserirNaBase(Connection connection, Produto produto) {
        String sql = "INSERT INTO produto (nome, descrição, quantidade, preco) values (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setInt(3, produto.getQuantidade());
            preparedStatement.setDouble(4, produto.getPreco());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new MineExceptions(e.getMessage());
        }
    }

    private static int getProdutoFilterBy(Connection connection, int produtoPosicao) {
        String sql = "SELECT * FROM produto ORDER BY ID ASC";
        int id = 0;
        int controle = 1;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();
            try (ResultSet rst = preparedStatement.getResultSet() ){
                while (rst.next()) {
                    if (controle == produtoPosicao) {
                        id = rst.getInt("ID");
                        break;
                    }
                    controle++;
                }
            }
        } catch (SQLException e) {
            throw new MineExceptions(e.getMessage());
        }
        return id;
    }

    public static void alterarProdutoDaPosicao(Connection connection, int produtoPosicao) {
        int id = ProdutoDAO.getProdutoFilterBy(connection, produtoPosicao);
        String sql = "UPDATE produto SET quantidade=999, preco=9999.99 WHERE ID =" + id;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new MineExceptions(e.getMessage());
        }
    }

    public static void deletarProdutoDaPosicao(Connection connection, int produtoPosicao) {
        int id = ProdutoDAO.getProdutoFilterBy(connection, produtoPosicao);
        String sql = "DELETE FROM produto WHERE ID =" + id;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new MineExceptions(e.getMessage());
        }
    }
}
