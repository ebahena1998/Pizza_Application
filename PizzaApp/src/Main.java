import java.io.*;
import java.util.ArrayList;

public class Main {

    InputStream is;
    OutputStream os;
    Menu menu;
    File file;

    public Main(InputStream is, OutputStream os, String fileName) {
        this.is = is;
        this.os = os;
        this.menu = Menu.getInstance();
        this.file = new File(fileName);
    }
    public static void main(String[] args) {
        try {

            new Main(System.in, System.out, "pizzaorder.txt").run();

        } catch(Exception e) {

            System.out.println(e.getMessage());

        }


    }

    public void checkFile() throws IOException {
        if(!this.file.exists()) {
            this.file.createNewFile();
        }
    }

    public void run() throws IOException{

        checkFile();
        Customer customer = new Customer();
        os.write(menu.welcomePrompt().getBytes());
        String input = "";
        while(!input.equals("1")) {
            input = readUserInput(is);
            if(menu.validateCharacterInput(input)) {
                os.write(menu.getERROR_CHARACTER().getBytes());
                os.write((char) 10);
            }
            else if(menu.validateIntegerInput(input)) {
                if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 2) {
                    os.write(menu.getERROR_NUMBER().getBytes());
                    os.write((char) 10);
                }
                else if(Integer.parseInt(input) == 2) {
                    os.write(menu.getEXIT_CASE().getBytes());
                    os.write((char)10);
                    System.exit(0);
                }
                else {
                    break;
                }
            }
            os.write(menu.getCUSTOMER_SELECTION().getBytes());
            os.write((char) 10);
        }

        ArrayList<Customer> customerList = new ArrayList<>();
        String pizzaInput = "";
        while(!pizzaInput.equals("9")) {
            os.write(menu.pizzaPrompt().getBytes());
            os.write(menu.getPIZZA_CUSTOMER_SELECTION().getBytes());
            pizzaInput = readUserInput(is);
            if(menu.validateCharacterInput(pizzaInput)) {
                os.write(menu.getERROR_CHARACTER().getBytes());
                os.write((char) 10);
            }
            else if(menu.validateIntegerInput(pizzaInput)) {
                if(Integer.parseInt(pizzaInput) < 1 || Integer.parseInt(pizzaInput) > menu.getPizzaListSize()) {
                    os.write(menu.getPIZZA_ERROR_NUMBER().getBytes());
                    os.write((char) 10);
                }
                else if(Integer.parseInt(pizzaInput) == 9) {
                    os.write((char) 10);
                    break;
                }
                else {
                    customer.addPizzaOrder(menu.getPizza(Integer.parseInt(pizzaInput)));
                }
            }
        }

        String drinkInput = "";
        while(!drinkInput.equals("8")) {
            os.write(menu.drinkPrompt().getBytes());
            os.write(menu.getDRINK_CUSTOMER_SELECTION().getBytes());
            drinkInput = readUserInput(is);
            if(menu.validateCharacterInput(drinkInput)) {
                os.write(menu.getERROR_CHARACTER().getBytes());
                os.write((char) 10);
            }
            else if(menu.validateIntegerInput(drinkInput)) {
                if(Integer.parseInt(drinkInput) < 1 || Integer.parseInt(drinkInput) > menu.getDrinkListSize()) {
                    os.write(menu.getDRINK_ERROR_NUMBER().getBytes());
                    os.write((char) 10);
                }
                else if(Integer.parseInt(drinkInput) == 8) {
                    os.write((char) 10);
                    break;
                }
                else {
                    customer.addDrinkOrder(menu.getDrink(Integer.parseInt(drinkInput)));
                }
            }
        }

        os.write("Enter customer's name: ".getBytes());
        customer.setName(readUserInput(is));
        os.write("Enter customer's phone number: ".getBytes());
        customer.setPhoneNumber(readUserInput(is));
        os.write((char)10);

        os = new FileOutputStream(file);
        os.write(customer.toString().getBytes());

        is.close();
        os.flush();
        os.close();
    }

    public String readUserInput(InputStream is) throws IOException {
        int i;
        String text = "";
        while((i = is.read()) != 10) {
            text += (char) i;
        }
        return text;
    }
}