import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Scanner; 
class Customer { 
    int payment; 
    public Customer(int payment) { 
        this.payment = payment; 
    } 
} 
class LemonadeStand { 
    private static final int LEMONADE_PRICE = 5; 
    private int changeInRegister; 
    public LemonadeStand(int initialChange) { 
        this.changeInRegister = initialChange; 
    } 
    public boolean serveCustomer(Customer customer) { 
        if (customer.payment < LEMONADE_PRICE) { 
            System.out.println("Customer does not have enough money."); 
            return false; 
        } 
        int changeRequired = customer.payment - LEMONADE_PRICE; 
        if (changeRequired > changeInRegister) { 
            System.out.println("Not enough change in register to serve the customer."); 
            return false; 
        } 
        changeInRegister -= changeRequired; 
        System.out.println("Customer served. Change given: " + changeRequired); 
        return true; 
    } 
} 
class LemonadeStandSimulation2 { 
    public static void main(String[] args) { 
        LemonadeStand stand = new LemonadeStand(20);  
        Queue<Customer> customers = new LinkedList<>(); 
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Welcome to the Lemonade Stand!"); 
        while (true) { 
            System.out.print("Enter payment amount of the customer (or type 'exit' to quit): "); 
            String input = scanner.nextLine(); 
            if (input.equalsIgnoreCase("exit")) { 
                break; 
            } 
            try { 
                int payment = Integer.parseInt(input); 
                customers.add(new Customer(payment)); 
            } catch (NumberFormatException e) { 
                System.out.println("Invalid input. Please enter a valid amount or 'exit' to quit."); 
                continue; 
            } 
            System.out.println("Customer added with payment: " + input); 
        } 
        while (!customers.isEmpty()) { 
            Customer currentCustomer = customers.poll(); 
            boolean served = stand.serveCustomer(currentCustomer); 
            if (!served) { 
                System.out.println("Unable to serve this customer."); 
                break;  // If one customer can't be served, stop serving further customers 
            } 
        } 
        scanner.close(); 
    } 
} 