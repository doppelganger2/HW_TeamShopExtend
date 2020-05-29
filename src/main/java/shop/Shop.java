package shop;

import shop.employee.Administrator;
import shop.employee.Cashier;
import shop.employee.Security;
import shop.enums.EDepartment;
import shop.enums.ERole;

import java.util.Map;
import java.util.TreeMap;

public class Shop {
    private static Security guard = new Security("Vasya", ERole.SECURITY);
    public static Administrator administrator = new Administrator("Vasili Petrovich", ERole.ADMINISTRATOR);
    private static Map<EDepartment, Department> departments = new TreeMap();
    private static Storage storage;
    private static CashRegister cashRegister = new CashRegister(1000, new Cashier("Olga", ERole.CASHIER));

    public static Department getDepartment(EDepartment department) {
        return departments.get(department);
    }

    public static Map<EDepartment, Department> getAllDepartments() {
        return departments;
    }

    public static Security getGuard() {
        return guard;
    }

    public static Storage getStorage() {
        return storage;
    }

    public static CashRegister getCashRegister() {
        return cashRegister;
    }

    public static void createDepartment(EDepartment eDepartment, Department department) {
        departments.put(eDepartment, department);
    }
}
