package shop.employee;

import shop.Check;
import shop.Customer;
import shop.Goods;
import shop.enums.ERole;
import shop.interfaces.ICashier;

import java.util.List;

public class Cashier extends Employee implements ICashier {

    public final double discountSum = 1000;
    public final float discountValue = 0.05F;

    public Cashier(String name, ERole role) {
        super(name, role);
    }


    public double getTotalCost(List<Goods> goods) {
        return goods.stream().mapToDouble(Goods::getPrice).sum();
    }


    public Check transaction(Customer customer) {
        double totalCost = getTotalCost(customer.getCart());

        if (totalCost <= customer.getMoney()) {

            if (totalCost >= discountSum) {
                customer.setDiscount(discountValue);
                customer.setMoney(customer.getMoney() - (totalCost - (totalCost * customer.getDiscount())));
            } else if (customer.getDiscount() == 0) {
                customer.setMoney(customer.getMoney() - totalCost);
            }

            customer.setCheck(new Check(customer.getCart()));

        } else {
            throw new ArithmeticException("Customer doesn't have enough money");
        }
        return new Check(customer.getCart());
    }
}
