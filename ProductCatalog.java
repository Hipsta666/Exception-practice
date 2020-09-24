

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    protected ArrayList<Product> listOfProd = new ArrayList<>();
    protected ArrayList<Integer> listOfId = new ArrayList<>();
    protected ArrayList<String> listOfName = new ArrayList<>();

    public List<Product> getAllProducts(){
        for (Product item: listOfProd){
            System.out.println(" " + item.getId() + " " +
                    item.getName() + " " +
                    item.getWeight() + " " +
                    item.getPrice() + " ");
        }
        return listOfProd;
    }

    public void createProduct(Product product) throws ProductAlreadyExists {
        for (Product item: listOfProd) {
            listOfName.add(item.getName());
        }

        if (listOfName.contains(product.getName())) {
            throw new ProductAlreadyExists("Product \"" + product.getName() + "\" already exists");
        }
        listOfProd.add(product);
    }

    public void updateProduct(Product product) throws ProductNotValid {
        int count = 0;

        if (product.getName().equals("")) throw new ProductNotValid("Product not valid by name");

        for (Product item: listOfProd){
            if (item.getId() == product.getId()){
                count++;
                item.setName(product.getName());
                item.setWeight(product.getWeight());
                item.setPrice(product.getPrice());
//                listOfProd.set(listOfId.indexOf(item), product);
            }
        }
        if (count == 0) throw new ProductNotFound("Product not found by index " + product.getId());

    }

    public void deleteProduct(int id){
        for (Product item: listOfProd) {
            listOfId.add((int) item.getId());
        }

        if (!listOfId.contains(id)) {
            throw new ProductNotFound("Product not found by index " + id);
        }

        listOfProd.removeIf(item -> item.getId() == id);

    }

}
