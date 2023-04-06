package shopping_cart;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Shop shop;
    private Cart cart;

    public Menu(Scanner scannerIn, Shop shop) {
        this.scanner = scannerIn;
        this.shop = shop;
        this.cart = new Cart();
    }

    /**
     * greet() reads their city and print shop name
     */
    public void greet() {
        String msg = scanner.nextLine();
        System.out.println("Your city is " + msg);
        System.out.println("Your shop is " + shop.getName());
        // shop.printProducts();

    }

    /**
     * getNextIntFromUser() reads the integer input from user.
     * 
     * @return int the integer option entered by user
     */
    private int getNextIntFromUser() {
        return scanner.nextInt();
    }

    /**
     * getNextStringLineFromUser() reads the integer input from user.
     * 
     * @return String the text entered by user
     */
    private String getNextStringLineFromUser() {
        scanner.nextLine(); // skip a line
        return (scanner.nextLine());
    }

    private MenuOption getNextOptionFromUser() {
        int selected = getNextIntFromUser();
        return(MenuOption.menuOptionFromOptionId(selected));    
    }


    public void executeMenu() {
        printMenu();

        MenuOption option = getNextOptionFromUser();
        while (option != MenuOption.EXIT) {
            String line = String.format("you selected option: %s%n", option.getDisplayValue());
            System.out.println(line);

            handleShopperMenuOptionSelection(option);

            printMenu();
            option = getNextOptionFromUser();
        }
        exit();
    }

    private void exit() {
        scanner.close();
    }

    private void findProduct() {
        String line;

        System.out.println("Please enter your product name:");
        line = getNextStringLineFromUser();

        System.out.println("You entered product name: " + line);

        int productId = shop.findProduct(line);
        System.out.println("the product id of " + line + ": " + productId);

        if (productId != -1) {
            Product product = shop.getProductById(productId);

            line = String.format("Product Id: %d, name: %s, price: %f%n",
                    product.getId(), product.getName(), product.getPrice());
            System.out.println(line);

        } else {
            System.out.println("Sorry, we cannot find your product.");
        }
        
    }
    
    private void addToCart() {

        System.out.println("Please product id: " );
        int productId = getNextIntFromUser();
        String line = String.format("%s %d", "you want to buy product id ", productId);
        System.out.println(line);
        
        cart.addToCart(shop.getProductById(productId) );

    }
    

    /**
     * 
     * executeMenu() lists menu options and execute menu option typed by user
     */
    private void handleShopperMenuOptionSelection(MenuOption option) {
    
            if (option == MenuOption.LIST_PRODUCTS) {
                shop.printProducts();

            } else if (option == MenuOption.BUY_PRODUCT) {
                addToCart();

            } else if (option == MenuOption.FIND_PRODUCT) {
                findProduct();

            } else if (option == MenuOption.SHOW_CART) {

            } else if (option == MenuOption.CHECKOUT) {

            }

    }

    /**
     * printMenu() prints list of menu options to users
     */
    private void printMenu() {
        StringBuilder wholeMenu = new StringBuilder();
        String line = String.format("Please select your shopping cart menu option:%n");
        wholeMenu.append(line);
        for (MenuOption option : MenuOption.values()) {
            String menuLine = String.format("%d: %s%n", option.id, option.displayValue);
            wholeMenu.append(menuLine);

        }
        System.out.println(wholeMenu.toString());
    }
}


