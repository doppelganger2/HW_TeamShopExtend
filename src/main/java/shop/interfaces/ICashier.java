package shop.interfaces;

import shop.Check;
import shop.Customer;
import shop.Goods;

import java.util.List;

public interface ICashier {

    double getTotalCost(List<Goods> goods);

    Check transaction(Customer customer);
}
