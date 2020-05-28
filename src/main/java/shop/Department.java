package shop;

import shop.Employee.IEmployee;
import shop.enums.EBrand;

import java.util.List;

public class Department {
    List<EBrand> brands;
    List<Goods> goods;
    List<IEmployee> consultants;

    public List<Goods> getGoods() {
        return goods;
    }
}
