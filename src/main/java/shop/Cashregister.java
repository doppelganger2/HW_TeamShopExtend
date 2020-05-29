package shop;

import shop.interfaces.ICashregister;
import shop.Employee.Cashier;

import java.util.ArrayDeque;
import java.util.Objects;

public class Cashregister implements ICashregister {
   private int number;
   private double money;
   private Cashier cashier;
   private ArrayDeque<Customer> queue = new ArrayDeque<>();

    public Cashregister() {
    }

    public Cashregister(Cashier cashier) {
        this.cashier = cashier;
    }

    public Cashregister(int number, double money, Cashier cashier) {
        this.number = number;
        this.money = money;
        this.cashier = cashier;
    }

    @Override
    public void addCustomerToQueue(Customer customer) {
        if(queue.isEmpty()){
            queue.addFirst(customer);
        }
        queue.addLast(customer);
    }

    @Override
    public void removeCustomerFromQueue() {
       cashier.transaction(Objects.requireNonNull(queue.pollFirst()));
    }
}
