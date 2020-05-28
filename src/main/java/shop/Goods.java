package shop;

import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;

import java.util.Objects;
import java.util.StringJoiner;

public class Goods {
    private static long staticID = 0;
    private long id;
    private String name;
    private EBrand brand;
    private EGroup group;
    private EDepartment department;
    private double price;
    private String info;

    public Goods(String name, EBrand brand, EGroup group, EDepartment department, double price, String info) {
        this.id = ++staticID;
        this.name = name;
        this.brand = brand;
        this.group = group;
        this.department = department;
        this.price = price;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EBrand getBrand() {
        return brand;
    }

    public EGroup getGroup() {
        return group;
    }

    public EDepartment getDepartment() {
        return department;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return id == goods.id &&
                Double.compare(goods.price, price) == 0 &&
                Objects.equals(name, goods.name) &&
                brand == goods.brand &&
                group == goods.group &&
                department == goods.department &&
                Objects.equals(info, goods.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brand, group, department, price, info);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Goods.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("brand=" + brand)
                .add("group=" + group)
                .add("department=" + department.getClass())
                .add("price=" + price)
                .add("info='" + info + "'")
                .toString();
    }
}
