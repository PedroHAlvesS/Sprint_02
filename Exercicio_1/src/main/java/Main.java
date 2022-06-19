import dao.ProductDAO;
import dao.DB;
import services.RandomProducts;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static String user = "root";
    public static String password = "teamo123";
    public static void main(String[] args) {
        int option = -1;
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("Menu de opções");
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir 3 produtos");
            System.out.println("2 - Atualizar o primeiro produto");
            System.out.println("3 - Deletar o segundo produto");
            while (option < 0 || option > 3) {
                System.out.println("Informe uma opcão: ");
                String optionString =  keyboard.nextLine();
                try {
                    option = Integer.parseInt(optionString);
                } catch (NumberFormatException e) {
                    System.out.println("Número inválido!");
                }
                if (option < 0 || option > 3) {
                    System.out.println("Número fora do range!");
                }
            }
            if (option == 0) {
                break;
            }

            DB db = new DB(Main.user, Main.password);
            Connection connection = db.initConnection();
            if (option == 1) {
                option1(connection);
                option = -1;
            }
            if (option == 2) {
                option2(connection);
                option = -1;
            }
            if (option == 3) {
                option3(connection);
                option = -1;
            }
        }


    }

    public static void option1(Connection connection) {
        try (connection){
            RandomProducts productsList = new RandomProducts();
            productsList.pickupProductsFromList();
            for (int i = 0; i < 3; i++) {
                ProductDAO.insertIntoDB(connection, productsList.getChosenProducts()[i]);
            }
        } catch(Exception e){
            System.out.println("Ocorreu um erro! "+ e.getMessage());
        }
    }

    public static void option2(Connection connection) {
        try (connection){
            ProdutoDAO.updateFirstProduct(connection, 1);
        } catch(Exception e){
            System.out.println("Ocorreu um erro! " + e.getMessage());
            e.getCause();
            e.getStackTrace();
        }
    }

    public static void option3(Connection connection) {
        try (connection){
            ProdutoDAO.deleteSecondProduct(connection, 2);
        } catch(Exception e){
            System.out.println("Ocorreu um erro! " + e.getMessage());
            e.getCause();
            e.getStackTrace();
        }
    }
}
