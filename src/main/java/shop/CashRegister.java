package shop;

import shop.interfaces.ICashregister;
import shop.employee.Cashier;

import java.util.ArrayDeque;
import java.util.Objects;

public class CashRegister implements ICashregister {
   private static int staticId = 0;
   private int id;
   private double money;
   private Cashier cashier;
   private ArrayDeque<Customer> queue = new ArrayDeque<>();

    public CashRegister() {
        this.id = ++staticId;
    }

    public CashRegister(Cashier cashier) {
        this.id = ++staticId;
        this.cashier = cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Cashier getCashier() {

        return cashier;
    }

    public double getMoney() {
        return money;
    }

    public CashRegister(double money, Cashier cashier) {
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
