package shop;

import com.sun.tools.javac.comp.Check;

import java.util.List;

public class Customer {
    String name;
    float discount;
    double money;
    List<Goods> cart;
    Check check;

    public Customer(String name, float discount, double money, List<Goods> cart, Check check) {
        this.name = name;
        this.discount = discount;
        this.money = money;
        this.cart = cart;
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<Goods> getCart() {
        return cart;
    }

    public void setCart(List<Goods> cart) {
        this.cart = cart;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }
}
