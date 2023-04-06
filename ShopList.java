package shopping_cart;

import java.util.ArrayList;

public class ShopList {
    private ArrayList<Product> items;
    private double total;
    private double taxRate;

    public ShopList() {
        this.items = new ArrayList<>();
        this.total = 0;
        this.taxRate = 0.10;

    }

    public void addItem(Product product) {
        items.add(product);
        total += product.getPrice();
    }

    /*
     * 
     * public void showDetails() {
     * StringBuilder details = new StringBuilder();
     * String line = String.format("The following items are in your cart: %n");
     * details.append(line);
     * 
     * for (Product product : items) {
     * line = String.format("Product id: %d, Product Name: %s, Price: %f%n",
     * product.getId(), product.getName(), product.getPrice());
     * details.append(line);
     * 
     * }
     * System.out.println(details.toString());
     * }
     *
     */

    
    public void showDetails() {
        StringBuilder details = new StringBuilder();

        if (items.size() > 0) {
            appendCartHeaderToStringBuilder(details);
            appendItemsWithPricesToStringBuilder(details);
        
        } else {
            String line = String.format("There are no items in your cart: %n");
            details.append(line);

        }
        System.out.println(details.toString());
    }

    void appendCartHeaderToStringBuilder(StringBuilder details) {
        String line = String.format("The following items are in your cart: %n");
        details.append(line);

    }

    void appendItemsWithPricesToStringBuilder(StringBuilder details) {
        String line;
        for (Product product : items) {
            line = String.format("Product id: %d, Product Name: %s, Price: %f%n",
                    product.getId(), product.getName(), product.getPrice());
            details.append(line);

        }

    }

    void appendCartTotalsToStringBuilder(StringBuilder details) {
        String line = String.format("Your subtotal: %.2f, Tax Rate : %.2f %%, Grand Total: %.2f%n",
                total, taxRate*100, total * (1 + taxRate));

        details.append(line);

    }

    public void checkOut() {
        StringBuilder details = new StringBuilder();

        if (items.size() > 0) {
            appendCartHeaderToStringBuilder(details);
            appendItemsWithPricesToStringBuilder(details);
            appendCartTotalsToStringBuilder(details);

        } else {
            String line = String.format("There are no items in your cart: %n");
            details.append(line);

        }
        System.out.println(details.toString());
        items.clear();
    }

}