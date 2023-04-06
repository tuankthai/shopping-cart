package shopping_cart;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> items;
    private double total;
    private double tax;

    public Cart() {
        this.items = new ArrayList<>();
        this.total = 0;
        this.tax = 0.10;
    }

    public void showDetails() {
        String line;
        StringBuilder details = new StringBuilder();
        line = String.format("Your shopping cart contains the following items:%n");
        details.append(line);

        for (Product product : items) {
            line = String.format("Product id: %d, Name: %s, Price: %d%n", product.getId(), product.getName(),
                    product.getPrice());
            details.append(line);
        }
        System.out.println(details.toString());

    }

    public void addToCart(Product product) {
        items.add(product);
    }
}


