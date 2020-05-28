package shop;

import shop.enums.EDepartment;

import java.util.Map;
import java.util.TreeMap;

public class Shop {
    private static Map<EDepartment, Department> departments = new TreeMap();

    public static Department getDepartment(EDepartment department) {
        return departments.get(department);
    }
}
