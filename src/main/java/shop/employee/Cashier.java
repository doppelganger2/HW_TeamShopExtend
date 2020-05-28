package shop.employee;

import shop.Check;
import shop.Customer;
import shop.Goods;
import shop.Interface.ICashier;

import java.util.List;

public class Cashier implements ICashier {

    public double getTotalCost(List<Goods> goods) {
        return goods.stream().mapToDouble(Goods::getPrice).sum();
    }

    public Check transaction(double totalCost, Customer customer) {
        if (totalCost <= customer.getMoney()) {
            customer.setMoney(customer.getMoney() - totalCost);
            customer.getCart().clear();
        } else {
            System.out.println("Customer doesn't have enough money");
            return null;
        }
        return new Check();
    }
}
