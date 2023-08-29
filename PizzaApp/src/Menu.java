import java.util.ArrayList;
import pizzaUtilMenu.Styles;

public class Menu {
    private final String WELCOME, CUSTOMER_SELECTION, OPTION_1, OPTION_2, EXIT, ERROR_NUMBER, ERROR_CHARACTER,
        SELECTION_PIZZA, PIZZA_SELECTION, SELECTION_DRINK, DRINK_SELECTION;
    private static final String PIZZA_QUIT_SELECTION = "Quit Pizza selection";
    private static final String DRINK_QUIT_SELECTION = "Quit Drinks selection";
    private final String INDEX;
    private static Menu self = null;
    private boolean isNumber = false;
    private ArrayList<Pizza> pizzaOption;
    private ArrayList<Drink> drinkOption;
    public static Menu getInstance() {
        if(self == null) {
            self = new Menu();
        }
        return self;
    }
    private Menu() {
        WELCOME = "======Welcome to Pizza Ordering System======";
        CUSTOMER_SELECTION = "===Select Customer Selection or Exit %s===";
        PIZZA_SELECTION = "Select Pizza: ";
        DRINK_SELECTION = "Select Drink: %s";
        INDEX = "[%d, %d]: ";
        OPTION_1 = "1.Customer Selection";
        OPTION_2 = "2.Exit";
        EXIT = "Exiting...";
        ERROR_NUMBER = "Error! Number must be %d or %d.";
        ERROR_CHARACTER = "Error! You must type a number.";

        SELECTION_PIZZA = "=== Select Pizza: ===";
        pizzaOption = new ArrayList<>();
        setPizzaMenu();

        SELECTION_DRINK = "=== Select Drinks: ===";
        drinkOption = new ArrayList<Drink>();
        setDrinkMenu();

    }

    public String getERROR_NUMBER() {
        return String.format(ERROR_NUMBER, 1, 2);
    }

    public String getERROR_CHARACTER() {
        return this.ERROR_CHARACTER;
    }
    public String getEXIT_CASE() {
        return this.EXIT;
    }
    public String getCUSTOMER_SELECTION() {
        return String.format(this.CUSTOMER_SELECTION ,String.format(this.INDEX, 1, 2));
    }
    public String getPizzaQuitSelection() {
        return String.format("%-3d %s",pizzaOption.size() + 1,PIZZA_QUIT_SELECTION);
    }
    public String getPIZZA_CUSTOMER_SELECTION() {
        return this.PIZZA_SELECTION + String.format(this.INDEX, 1, pizzaOption.size() + 1);
    }
    public String getPIZZA_ERROR_NUMBER() {
        return String.format(ERROR_NUMBER, 1, getPizzaListSize());
    }

    public int getPizzaListSize() {
        return this.pizzaOption.size() + 1;
    }
    public Pizza getPizza(int num) {
        switch (num) {
            case 1: return this.pizzaOption.get(0);
            case 2: return this.pizzaOption.get(1);
            case 3: return this.pizzaOption.get(2);
            case 4: return this.pizzaOption.get(3);
            case 5: return this.pizzaOption.get(4);
            case 6: return this.pizzaOption.get(5);
            case 7: return this.pizzaOption.get(6);
            case 8: return this.pizzaOption.get(7);
        }
        return null;
    }

    public Drink getDrink(int num) {
        switch (num) {
            case 1: return this.drinkOption.get(0);
            case 2: return this.drinkOption.get(1);
            case 3: return this.drinkOption.get(2);
            case 4: return this.drinkOption.get(3);
            case 5: return this.drinkOption.get(4);
            case 6: return this.drinkOption.get(5);
            case 7: return this.drinkOption.get(6);
        }
        return null;
    }

    public String getDrinkQuitSelection() {
        return String.format("%-3d %s", drinkOption.size() + 1, DRINK_QUIT_SELECTION);
    }
    public String getDRINK_CUSTOMER_SELECTION() {
        return String.format(this.DRINK_SELECTION, String.format(INDEX, 1 , drinkOption.size() + 1));
    }
    public String getDRINK_ERROR_NUMBER() {
        return String.format(ERROR_NUMBER, 1, getDrinkListSize());
    }
    public int getDrinkListSize() {
        return this.drinkOption.size() + 1;
    }


    public boolean validateCharacterInput(String input) {
        return Character.isAlphabetic(input.charAt(0));
    }

    public boolean validateIntegerInput(String input) {
        return Character.isDigit(input.charAt(0));
    }

    public void setPizzaMenu() {
        for(int i = 1; i < 9; i++) {
            switch (i) {
                case 1: pizzaOption.add(new Pizza(Styles.TOPPING_HAWAIIAN, Styles.EXTRA_LARGE, 14.00, i));
                break;
                case 2: pizzaOption.add(new Pizza(Styles.TOPPING_HAWAIIAN, Styles.REGULAR, 12.00, i));
                break;
                case 3: pizzaOption.add(new Pizza(Styles.TOPPING_BUFFALO, Styles.EXTRA_LARGE, 12.00, i));
                break;
                case 4: pizzaOption.add(new Pizza(Styles.TOPPING_BUFFALO, Styles.REGULAR, 10.00, i));
                break;
                case 5: pizzaOption.add(new Pizza(Styles.TOPPING_CHEESE, Styles.EXTRA_LARGE, 10.00, i));
                break;
                case 6: pizzaOption.add(new Pizza(Styles.TOPPING_CHEESE, Styles.REGULAR, 8.00, i));
                break;
                case 7: pizzaOption.add(new Pizza(Styles.TOPPING_VEGGIE, Styles.EXTRA_LARGE, 10.00, i));
                break;
                case 8: pizzaOption.add(new Pizza(Styles.TOPPING_VEGGIE, Styles.REGULAR, 8.00, i));
                break;
            }
        }
    }

    public void setDrinkMenu() {
        for(int i = 1; i < 8; i++) {
            switch (i) {
                case 1: drinkOption.add(new Drink("Ice Tea", 1.50, i));
                break;
                case 2: drinkOption.add(new Drink("Soft Drinks", 2.00, i));
                break;
                case 3: drinkOption.add(new Drink("Bottled Water", 1.50, i));
                break;
                case 4: drinkOption.add(new Drink("Espresso", 4.50, i));
                break;
                case 5: drinkOption.add(new Drink("Latte", 4.50, i));
                break;
                case 6: drinkOption.add(new Drink("Cappuccino", 6.50, i));
                break;
                case 7: drinkOption.add(new Drink("Cold Brew", 4.00, i));
                break;
            }
        }
    }

    public String getPizzaList() {
        String pizzaList = "";
        for(Pizza p : this.pizzaOption) {
            pizzaList += p.toString();
        }
        pizzaList += getPizzaQuitSelection();
        return pizzaList;
    }

    public String getDrinkList() {
        String drinkList = "";
        for(Drink d : this.drinkOption) {
            drinkList += d.toString();
        }
        drinkList += getDrinkQuitSelection();
        return drinkList;
    }

    public String welcomePrompt() {
        return String.format("%s%n%n%s%n%s%n%s%n", WELCOME, getCUSTOMER_SELECTION(), OPTION_1, OPTION_2);
    }
    public String pizzaPrompt() {
        return String.format("%s%n%s%n", SELECTION_PIZZA, getPizzaList());
    }
    public String drinkPrompt() {
        return String.format("%s%n%s%n", SELECTION_DRINK, getDrinkList());
    }
}
