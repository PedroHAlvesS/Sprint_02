package dao;

import domain.Product;
import exceptions.MineExceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

    public static void insertIntoDB(Connection connection, Product product) {
        String sql = "INSERT INTO produto (nome, descrição, quantidade, preco) values (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new MineExceptions(e.getMessage());
        }
    }

    private static int getProdutoFilterBy(Connection connection, int productPosition) {
        String sql = "SELECT * FROM produto ORDER BY ID DESC";
        if (productPosition == 1) {
            productPosition = 3;
        }
        int id = 0;
        int controle = 1;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();
            try (ResultSet rst = preparedStatement.getResultSet() ){
                while (rst.next()) {
                    if (controle == productPosition) {
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

    public static void updateFirstProduct(Connection connection, int produtoPosicao) {
        int id = ProdutoDAO.getProdutoFilterBy(connection, produtoPosicao);
        String sql = "UPDATE produto SET quantidade=999, preco=9999.99 WHERE ID =" + id;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new MineExceptions(e.getMessage());
        }
    }

    public static void deleteSecondProduct(Connection connection, int produtoPosicao) {
        int id = ProdutoDAO.getProdutoFilterBy(connection, produtoPosicao);
        String sql = "DELETE FROM produto WHERE ID =" + id;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new MineExceptions(e.getMessage());
        }
    }
}
