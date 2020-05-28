package shop;

import shop.Employee.Employee;
import shop.Employee.StoreKeeper;

import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;
import shop.enums.ERole;

import java.util.List;
import java.util.Map;

public class Storage {

    static Map<String, GoodsWrapper> goodsMap;
    static List<EBrand> brands;
    static List<EGroup> groups;
    static List<EDepartment> departments;
    static Employee storeKeeper = new StoreKeeper("Semen", ERole.STORE_KEEPER);

    public static Map<String, GoodsWrapper> getGoodsMap() {
        return goodsMap;
    }

    public static List<EBrand> getBrands() {
        return brands;
    }

    public static List<EGroup> getGroups() {
        return groups;
    }

    public static List<EDepartment> getDepartments() {
        return departments;
    }

    public static Employee getStoreKeeper() {
        return storeKeeper;
    }
}
