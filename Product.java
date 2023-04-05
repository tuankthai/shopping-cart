package shopping_cart;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;

    }
    
    public int getId() {
        return this.id; 
    }

    public double getPrice() {
        return this.price;
    }
    
}
