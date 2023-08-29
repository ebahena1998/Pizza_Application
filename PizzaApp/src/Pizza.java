public class Pizza {
    private static final String PIZZA_TITLE = "Pizza";
    private String type;
    private String size;
    private double cost;
    private int id;
    private int totalPizza;

    public Pizza(String type, String size, double cost, int id) {
        this.type = type;
        this.size = size;
        this.cost = cost;
        this.id = id++;
        this.totalPizza = 1;

    }
    public double getCost() {
        return this.cost;
    }
    public int getId() {
        return this.id;
    }
    public int getTotalPizza() {
        return this.totalPizza;
    }
    public void setSameAmount() {
        this.totalPizza++;
    }

    public String toString() {
        return String.format("%-3d %-11s %-8s %-15s $%.2f%n",id ,type, PIZZA_TITLE, size, cost);
    }

    public String customerPizzaString() {
        return String.format("%s %s %s", type, PIZZA_TITLE, size);
    }

    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;

        Pizza pizza = (Pizza) o;
        if(pizza.getId() == this.id && pizza.type.equals(this.type)) {
            return true;
        }
        else {
            return false;
        }
    }
}
