package shopping_cart;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Shop shop;

    public Menu(Scanner scannerIn, Shop shop) {
        this.scanner = scannerIn;
        this.shop = shop;
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

    /**
     * executeMenu() lists menu options and execute menu option typed by user
     */
    public void executeMenu() {
        printMenu();
        int selected = getNextIntFromUser();
        MenuOption option = MenuOption.menuOptionFromOptionId(selected);
        while (option != MenuOption.EXIT) {
            String line = String.format("you selected option: %s%n", option.getDisplayValue());
            System.out.println(line);

            if (option == MenuOption.LIST_PRODUCTS) {
                shop.printProducts();

            } else if (option == MenuOption.BUY_PRODUCT) {

            } else if (option == MenuOption.FIND_PRODUCT) {

                System.out.println("Please your product name:");
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

            } else if (option == MenuOption.SHOW_CART) {

            } else if (option == MenuOption.CHECKOUT) {

            }

            printMenu();
            selected = getNextIntFromUser();
            option = MenuOption.menuOptionFromOptionId(selected);
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
