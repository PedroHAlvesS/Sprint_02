package dao;

import domain.Product;

import java.sql.*;

public class ProductDAO {

    public static void insertIntoDB(Connection connection, Product product) {
        String sql = "INSERT INTO produto (nome, descrição, quantidade, preco) values (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.execute();
            try(ResultSet rst = preparedStatement.getGeneratedKeys()) {
                System.out.println("=====");
                while(rst.next()) {
                    System.out.println("Adicionado o produto id: " + rst.getInt(1));
                }
                System.out.println("=====");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static int getProductIDFilterBy(Connection connection, int productPosition) {
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
            throw new RuntimeException(e.getMessage());
        }
        return id;
    }

    public static void updateFirstProduct(Connection connection, int produtoPosicao) {
        int id = ProductDAO.getProductIDFilterBy(connection, produtoPosicao);
        String sql = "UPDATE produto SET nome = 'YYY--Jequiti--YYY' WHERE ID =" + id;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
            try (ResultSet rst = preparedStatement.getResultSet()) {
                if (rst.getRow() == 0) {
                    System.out.println("Não foi atualizado nenhum produto!");
                } else {
                    System.out.println("====");
                    System.out.println("Produto de id " + id + " atualizado!");
                    System.out.println("====");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteSecondProduct(Connection connection, int produtoPosicao) {
        int id = ProductDAO.getProductIDFilterBy(connection, produtoPosicao);
        String sql = "DELETE FROM produto WHERE ID =" + id;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();
            try (ResultSet rst = preparedStatement.getResultSet()) {
                if (rst.getRow() == 0) {
                    System.out.println("Não foi deletado nenhum produto!");
                } else {
                    System.out.println("====");
                    System.out.println("Produto de id " + id + " deletado!");
                    System.out.println("====");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
