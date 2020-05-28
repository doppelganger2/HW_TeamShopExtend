package shop;

import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;

public class Goods {
    long uniqueID;
    String name;
    EBrand brand;
    EGroup group;
    EDepartment department;
    double price;
    String info;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public EBrand getBrand() {
        return brand;
    }

    public EGroup getGroup() {
        return group;
    }

    public String getInfo() {
        return info;
    }
}
