package shop.employee;

import shop.Customer;
import shop.Interface.ISecurity;

public class Security implements ISecurity {

    @Override
    public boolean checkCustomer(Customer customer) {
        return false;
    }
}
