import dao.ProductDAO;
import dao.DB;
import services.Menu;
import services.RandomProducts;

import java.sql.Connection;

public class Main {

    public static String user = "";
    public static String password = "";
    public static void main(String[] args) {
        while (true) {
            int option = Menu.getOptionFromMenu();

            if (option == 0) {
                break;
            }

            DB db = new DB(Main.user, Main.password);
            Connection connection = db.initConnection();
            if (option == 1) {
                option1(connection);
            }
            if (option == 2) {
                option2(connection);
            }
            if (option == 3) {
                option3(connection);
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
            ProductDAO.updateFirstProduct(connection, 1);
        } catch(Exception e){
            System.out.println("Ocorreu um erro! " + e.getMessage());
            e.getCause();
            e.getStackTrace();
        }
    }

    public static void option3(Connection connection) {
        try (connection){
            ProductDAO.deleteSecondProduct(connection, 2);
        } catch(Exception e){
            System.out.println("Ocorreu um erro! " + e.getMessage());
            e.getCause();
            e.getStackTrace();
        }
    }
}
