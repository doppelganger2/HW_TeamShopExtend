package shop.interfaces;

import shop.Customer;

public interface ICashregister {
    void addCustomerToQueue(Customer customer);

    void removeCustomerFromQueue();

}
