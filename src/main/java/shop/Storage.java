package shop;

import shop.employee.StoreKeeper;
import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;
import shop.enums.ERole;
import shop.interfaces.IStoreKeeper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {

    private static IStoreKeeper storeKeeper = new StoreKeeper("Semen", ERole.STORE_KEEPER);
    private static Map<String, GoodsWrapper> goodsMap = new HashMap<>();
    private static List<EBrand> brands = new ArrayList<>();
    private static List<EGroup> groups = new ArrayList<>();
    private static List<EDepartment> departments = new ArrayList<>();

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

    public static IStoreKeeper getStoreKeeper() {
        return storeKeeper;
    }
}
