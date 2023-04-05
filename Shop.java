package shopping_cart;

import java.util.ArrayList;

public class Shop {
    private String name;
    private ArrayList<Product> products;

    /**
     * constructor initializes shop name and list of products with id, name, price
     * @param name
     * @param products
     */
    public Shop(String name, ArrayList<Product> products) {
        this.name = name;
        this.products = products;
    }

    /**
     * getName returns shop name
     * @return String shop name
     */
    public String getName() {
        return this.name;
    }

    /**
     * printProducts list all products with their id, name, price
     */
    public void printProducts() {
        String line;
        for (Product product : products) {
            line = String.format("product id: %d, name: %s, price: %f%n", 
            product.getId(), product.getName(), product.getPrice());
            System.out.println(line);
        }

    }

    /**
     * findProduct looks for product name matching the request name
     * and return product id
     * @param searchName
     * @return int prodcut id
     */
    public int findProduct(String searchName) {
        for (Product product : products) {
            if (product.getName().equals(searchName) ) {
                return product.getId();
            }
        }
        return -1;
    }

    /**
     * getProductById looks for product matching id and return Product object 
     * @param id product id
     * @return Product product object
     */
    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;

    }

}
