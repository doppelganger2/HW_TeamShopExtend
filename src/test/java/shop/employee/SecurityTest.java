package shop.employee;

import org.junit.jupiter.api.Test;
import shop.Check;
import shop.Customer;
import shop.Goods;
import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;
import shop.enums.ERole;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityTest {

    @Test
    void checkCustomerTestValidCheck() {

        Customer testCustomer = new Customer("SerGay", 0, 292);
        testCustomer.setCart(new ArrayList<Goods>(Arrays.asList(new Goods("test1", EBrand.NEW_BALANCE, EGroup.HOODIES, EDepartment.ACCESSORIES_DEPARTMENT, 10f, ""),
                new Goods("test2", EBrand.NIKE, EGroup.SHOES, EDepartment.CLOTHES_DEPARTMENT, 5f, ""),
                new Goods("test3", EBrand.REEBOK, EGroup.T_SHIRTS, EDepartment.SHOES_DEPARTMENT, 8f, ""))));

        Security testSecurity = new Security("Alex", ERole.SECURITY);

        Check testCheck = new Check(testCustomer.getCart());
        testCustomer.setCheck(testCheck);

        boolean actual = testSecurity.checkCustomer(testCustomer);

        assertTrue(actual);
    }

    @Test
    void checkCustomerTestInvalidCheck() {

        Customer testCustomer = new Customer("SerGay", 0, 292);
        testCustomer.setCart(new ArrayList<Goods>(Arrays.asList(new Goods("test1", EBrand.NEW_BALANCE, EGroup.HOODIES, EDepartment.ACCESSORIES_DEPARTMENT, 10f, ""),
                new Goods("test2", EBrand.NIKE, EGroup.SHOES, EDepartment.CLOTHES_DEPARTMENT, 5f, ""),
                new Goods("test3", EBrand.REEBOK, EGroup.T_SHIRTS, EDepartment.SHOES_DEPARTMENT, 8f, ""))));

        Customer testCustomer2 = new Customer("SerGay", 0, 292);
        testCustomer.setCart(new ArrayList<Goods>(Arrays.asList(new Goods("test1", EBrand.NEW_BALANCE, EGroup.HOODIES, EDepartment.ACCESSORIES_DEPARTMENT, 10f, ""),
                new Goods("test22", EBrand.NIKE, EGroup.SHOES, EDepartment.CLOTHES_DEPARTMENT, 5f, ""),
                new Goods("test3", EBrand.REEBOK, EGroup.T_SHIRTS, EDepartment.SHOES_DEPARTMENT, 8f, ""))));

        Security testSecurity = new Security("Alex", ERole.SECURITY);

        Check testCheck = new Check(testCustomer2.getCart());
        testCustomer.setCheck(testCheck);

        boolean actual = testSecurity.checkCustomer(testCustomer);

        assertFalse(actual);
    }

    @Test
    void checkCustomerTestNullCheck() {

        Customer testCustomer = new Customer("SerGay", 0, 292);
        testCustomer.setCart(new ArrayList<Goods>(Arrays.asList(new Goods("test1", EBrand.NEW_BALANCE, EGroup.HOODIES, EDepartment.ACCESSORIES_DEPARTMENT, 10f, ""),
                new Goods("test2", EBrand.NIKE, EGroup.SHOES, EDepartment.CLOTHES_DEPARTMENT, 5f, ""),
                new Goods("test3", EBrand.REEBOK, EGroup.T_SHIRTS, EDepartment.SHOES_DEPARTMENT, 8f, ""))));
        Security testSecurity = new Security("Alex", ERole.SECURITY);

        boolean actual = testSecurity.checkCustomer(testCustomer);

        assertFalse(actual);
    }
}