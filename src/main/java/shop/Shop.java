package shop;

import shop.employee.Security;
import shop.enums.EDepartment;
import shop.enums.ERole;

import java.util.Map;
import java.util.TreeMap;

public class Shop {
    private static Security guard = new Security("Vasya", ERole.SECURITY);
    private static Map<EDepartment, Department> departments = new TreeMap();
    private static Storage storage = new Storage();

    public static Department getDepartment(EDepartment department) {
        return departments.get(department);
    }

    public static Security getGuard() {
        return guard;
    }
}
