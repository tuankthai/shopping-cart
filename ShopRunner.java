package shopping_cart;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShopRunner {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>(
            Arrays.asList(new Product(0, "Crew Neck", 20.00), 
                        new Product(1, "V Neck", 20.00),
                        new Product(2, "Polo", 25.50),
                        new Product(3, "Boat Neck", 30.25),
                        new Product(4, "Tank top", 15.75)
                         ));
            
        Shop shop = new Shop("Tuan T-Short Mart", products);

        //Scanner scanner; // = new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8")));
        Menu menu = new Menu(new Scanner(new InputStreamReader(System.in,
                 Charset.forName("UTF-8"))), shop);

        System.out.println("Hello World! Please type your city and hit enter.");
        menu.greet();
        menu.executeMenu();
                    
    }

}