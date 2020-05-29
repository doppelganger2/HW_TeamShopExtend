package shop;

import shop.Interface.ICashregister;
import shop.Employee.Cashier;

import java.util.ArrayDeque;
import java.util.Objects;

public class Cashregister implements ICashregister {
    int number;
    double money;
    Cashier cashier;
   ArrayDeque<Customer> queue = new ArrayDeque<>();

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
