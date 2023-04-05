package shopping_cart;

import java.util.Scanner;

public class Menu {
    Scanner scanner;
    Shop shop;

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
        shop.printProducts();

    }
    
    private int getNextIntFromUser() {
        return scanner.nextInt();
    }
    
    private String getNextStringLineFromUser() {
        scanner.nextLine(); //skip  a line
        return(scanner.nextLine()); 
    }
    

    /**
     * executeMenu() lists menu options and execute menu option typed by user
     */
    public void executeMenu() {
        printMenu();
        System.out.println("Please type your menu option:");
        int selected = getNextIntFromUser();
        MenuOption option = MenuOption.menuOptionFromOptionId(selected);
        while (option != MenuOption.EXIT) {
            String line = String.format("you selected option: %s%n", option.getDisplayValue());
            Systems.out.println(line);
         }

    }
    
    private void printMenu() {
        StringBuilder wholeMenu = new StringBuilder();
        String line = String.format("Shopping Cart Menu Option:%n");
        wholeMenu.append(line);
        for (MenuOption option : MenuOption.values()) {
            String menuLine= String.format("%d: %s%n", option.id, option.displayValue);
            wholeMenu.append(menuLine);

        }
        System.out.println(wholeMenu.toString());
    }
}
