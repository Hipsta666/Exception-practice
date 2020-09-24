

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){


        ProductCatalog catalog = new ProductCatalog();

        try {
            catalog.createProduct(new Product(1, "Pasta", 400, 190));
            catalog.createProduct(new Product(2, "Pizza", 800, 500));
            catalog.createProduct(new Product(3, "Ice Cream", 200, 150));
            catalog.createProduct(new Product(4, "Beef", 1500, 390));
            catalog.createProduct(new Product(5, "Ketchup", 300, 99));
//            catalog.createProduct(new Product(6, "Ice Cream", 200, 150));
        }

        catch (ProductAlreadyExists e) {
            System.err.println(e.getMessage());
        }

        System.out.println(catalog.getAllProducts());

        try {
            catalog.deleteProduct(1);   // Тест: id = 0.
            catalog.updateProduct(new Product(2, "Bread", 250, 25)); // Тест: name = "".
        }
        catch (ProductNotFound | ProductNotValid e) {
            System.err.println(e.getMessage());
        }

        System.out.println(catalog.getAllProducts());

    }
}
