package shop;

import shop.Employee.Cashier;
import shop.employee.Administrator;
import shop.employee.Security;
import shop.enums.EDepartment;
import shop.enums.ERole;

import java.util.Map;
import java.util.TreeMap;

public class Shop {
    private static Security guard = new Security("Vasya", ERole.SECURITY);
    public static Administrator administrator = new Administrator("",ERole.ADMINISTRATOR);

    private static Map<EDepartment, Department> departments = new TreeMap();
    private static Storage storage = new Storage();
    private static Cashregister cashregister = new Cashregister(new Cashier());


    public static Department getDepartment(EDepartment department) {
        return departments.get(department);
    }

    public static Security getGuard() {
        return guard;
    }

}
