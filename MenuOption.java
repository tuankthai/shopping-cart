package shopping_cart;

public enum MenuOption {
    EXIT(0, "Exit"),
    LIST_PRODUCTS(1, "List Products"),
    BUY_PRODUCT(2, "Buy Product"),
    FIND_PRODUCT(3, "Find Product"),
    SHOW_CART(4, "Show Cart"),
    CHECKOUT(5, "Checkout");

    int id;
    String displayValue;

    /**
     * constructor MenuOption instance with id and text
     */
    MenuOption(int id, String MenuName) {
        this.id = id;
        this.displayValue = MenuName;
    }

    /**
     * getDisplayValue returns displayValue of the instance
     * @return String Menu Option Text
     */
    public String getDisplayValue() {
        return this.displayValue;
    }

    /**
     * getId returns id of the instance
     * @return int Menu Option id
     */
    public int getId() {
        return this.id;
    }

    /**
     * menuOptionFromOptionId() converts an integer option into a Menu Option object
     * @param optionId the integer option
     * @return MenuOption the matching Menu Option object
     */
    public static MenuOption menuOptionFromOptionId(int optionId) {
        for (MenuOption option : MenuOption.values()) {
            if (option.id == optionId) {
                return option;
            }

        }
        return MenuOption.EXIT;
    }
}