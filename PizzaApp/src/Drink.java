public class Drink {
    private String type;
    private double cost;
    private int id;
    private int totalDrink;

    public Drink(String type, double cost, int id) {
        this.type = type;
        this.cost = cost;
        this.id = id++;
        this.totalDrink = 1;

    }

    public double getCost() {
        return this.cost;
    }
    public int getId() {
        return this.id;
    }
    public void setSameAmount() {
        this.totalDrink++;
    }
    public int getTotalDrink() {
        return this.totalDrink;
    }

    public String toString(){
        return String.format("%-3d %-15s $%.2f%n", id, type, cost);
    }

    public String customerDrinkString() {
        return String.format("%s", type);
    }

    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        Drink drink = (Drink) o;
        if(drink.getId() == this.id && drink.type.equals(this.type))
            return true;
        else
            return false;
    }
}
