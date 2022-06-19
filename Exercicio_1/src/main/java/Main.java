import dao.ProdutoDAO;
import dao.DB;
import services.ProdutosAleatorios;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static String user = "root";
    public static String password = "teamo123";
    public static void main(String[] args) {
        int opcao = -1;
        Scanner teclado = new Scanner(System.in);
        while (true) {
            System.out.println("Menu de opções");
            System.out.println("0 - sair");
            System.out.println("1 - Inserir 3 produtos");
            System.out.println("2 - Atualizar o primeiro produto");
            System.out.println("3 - Deletar o segundo produto");
            while (opcao < 0 || opcao > 3) {
                System.out.println("Informe uma opcão: ");
                String escolha =  teclado.nextLine();
                try {
                    opcao = Integer.parseInt(escolha);
                } catch (NumberFormatException e) {
                    System.out.println("Número inválido!");
                }
                if (opcao < 0 || opcao > 3) {
                    System.out.println("Número fora do range!");
                }
            }
            if (opcao == 0) {
                break;
            }

            DB db = new DB(Main.user, Main.password);
            Connection connection = db.initConnection();
            if (opcao == 1) {
                opcao1(connection);
                opcao = -1;
            }
            if (opcao == 2) {
                opcao2(connection);
                opcao = -1;
            }
            if (opcao == 3) {
                opcao3(connection);
                opcao = -1;
            }
        }


    }

    public static void opcao1(Connection connection) {
        try (connection){
            ProdutosAleatorios listaDeProdutos = new ProdutosAleatorios();
            listaDeProdutos.escolherProdutosDaLista();
            for (int i = 0; i < 3; i++) {
                ProdutoDAO.inserirNaBase(connection, listaDeProdutos.getProdutosSelecionados()[i]);
            }
        } catch(Exception e){
            System.out.println("Ocorreu um erro! "+ e.getMessage());
        }
    }

    public static void opcao2(Connection connection) {
        try (connection){
            ProdutoDAO.updateFirstProduct(connection, 1);
        } catch(Exception e){
            System.out.println("Ocorreu um erro! " + e.getMessage());
            e.getCause();
            e.getStackTrace();
        }
    }

    public static void opcao3(Connection connection) {
        try (connection){
            ProdutoDAO.deleteSecondProduct(connection, 2);
        } catch(Exception e){
            System.out.println("Ocorreu um erro! " + e.getMessage());
            e.getCause();
            e.getStackTrace();
        }
    }
}
