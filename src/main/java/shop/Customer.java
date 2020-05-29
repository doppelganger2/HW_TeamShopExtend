package shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Customer {
    private static long staticID = 0;
    private long id;
    private String name;
    private double discount;
    private double money;
    private List<Goods> cart = new ArrayList<>();
    private Check check;

    public Customer(String name, double discount, double money) {
        this.id = ++staticID;
        this.name = name;
        this.discount = discount;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }

    public double getMoney() {
        return money;
    }

    public List<Goods> getCart() {
        return cart;
    }

    public Check getCheck() {
        return check;

    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setCart(List<Goods> cart) {
        this.cart = cart;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Double.compare(customer.discount, discount) == 0 &&
                Double.compare(customer.money, money) == 0 &&
                Objects.equals(name, customer.name) &&
                Objects.equals(cart, customer.cart) &&
                Objects.equals(check, customer.check);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, discount, money, cart, check);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("discount=" + discount)
                .add("money=" + money)
                .add("cart=" + cart)
                .add("check=" + check)
                .toString();
    }
}
