import java.util.ArrayList;

public class Customer {
    private String name;
    private String phoneNumber;
    private double totalCost;
    private ArrayList<Pizza> pizzaOrders;
    private ArrayList<Pizza> dupPizza;
    private ArrayList<Drink> drinkOrders;
    private ArrayList<Drink> dupDrink;

    public Customer() {
        this.name = "NO NAME";
        this.phoneNumber = "NO PHONE NUMBER";
        this.totalCost = 0.00;

        pizzaOrders = new ArrayList<>();
        dupPizza = new ArrayList<>();

        drinkOrders = new ArrayList<>();
        dupDrink  = new ArrayList<>();
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addPizzaOrder(Pizza pObj) {
        this.pizzaOrders.add(pObj);
        this.addCost(pObj.getCost());
    }

    public void addDrinkOrder(Drink dObj) {
        this.drinkOrders.add(dObj);
        this.addCost(dObj.getCost());
    }

    public void addCost(double amount) {
        this.totalCost += amount;

    }

    public void getCommonPizza() {
        for(Pizza p: pizzaOrders) {
            if(!dupPizza.contains(p)) {
                dupPizza.add(p);
            }
            else {
                p.setSameAmount();
            }
        }
    }

    public void getCommonDrink() {
        for(Drink d: drinkOrders) {
            if(!dupDrink.contains(d)) {
                dupDrink.add(d);
            }
            else {
                d.setSameAmount();
            }
        }
    }
    public String getOrders() {
        String pOrder = "";
        String dOrder = "";
        String result = "%s %s";
        getCommonPizza();
        for(Pizza p : dupPizza) {
            pOrder += p.customerPizzaString().strip() + "(" + p.getTotalPizza() + "); ";
        }
        getCommonDrink();
        for(Drink d: dupDrink) {
            dOrder += d.customerDrinkString().strip() + "(" + d.getTotalDrink() + "); ";
        }
        dOrder = dOrder.substring(0, dOrder.lastIndexOf(";"));

        return String.format(result.strip(), pOrder.strip(), dOrder.strip());

    }

    public String toString() {
        return String.format("Customer name: %s; Phone: %s%n%s%nTotal Cost: $%.2f", name, phoneNumber,
                getOrders(), totalCost);
    }
}
