package services;

import domain.Product;

import java.util.ArrayList;
import java.util.Random;

public class RandomProducts {
    private  Product[] chosenProducts = new Product[3];
    private static ArrayList<Product> products = new ArrayList<Product>();

    public Product[] getChosenProducts() {
        return chosenProducts;
    }

    public void pickupProductsFromList() {
        RandomProducts.productsList();
        int[] numbersAlreadyChosen = {0, 0, 0} ;
        int j = 0;
        while (j < 3) {
            boolean duplicate = false;
            int random = new Random().nextInt(products.size());
            for (int i = 0; i < 3; i++) {
                if (numbersAlreadyChosen[i] == random) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                this.chosenProducts[j] = products.get(random);
                numbersAlreadyChosen[j] = random;
                j++;
            }
        }

    }

    private static void productsList() {
        Product product1 = new Product("Água", "Água Mineral", 1, 2.0);
        addProductsToList(product1);
        Product product2 = new Product("Sorvete", "Sorvete de morango", 1, 10.5);
        RandomProducts.addProductsToList(product2);
        Product product3 = new Product("Picolé", "Picolé de chocolate", 1, 5.85);
        RandomProducts.addProductsToList(product3);
        Product product4 = new Product("Biscoito", "Biscoito Recheado", 1, 2.28);
        RandomProducts.addProductsToList(product4);
        Product product5 = new Product("Panela", "Panela de pressão", 1, 120.49);
        RandomProducts.addProductsToList(product5);

    }

    private static void addProductsToList(Product product) {
        RandomProducts.products.add(product);
    }

}
