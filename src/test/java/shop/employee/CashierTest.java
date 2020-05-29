package shop.employee;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.*;
import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;
import shop.enums.ERole;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {

    @Test
    void getTotalCostTest() {
        Customer vasya = new Customer("Vasya", 0.05, 1000);
        vasya.setCart(new ArrayList<>(Arrays.asList(new Goods("t-shirt", EBrand.NIKE, EGroup.T_SHIRTS
                        , EDepartment.CLOTHES_DEPARTMENT, 150, "women's New Balance hoodie pink size 31"),
                new Goods("hoodie", EBrand.NEW_BALANCE, EGroup.HOODIES
                        , EDepartment.CLOTHES_DEPARTMENT, 300, "men's black slim t- shirt, size 38"),
                new Goods("Reebok sneakers", EBrand.REEBOK, EGroup.SHOES
                        , EDepartment.SHOES_DEPARTMENT, 500, "men's Reebok classic white sneakers, size 44"))));

        double expected = 950;
        double actual = Shop.getCashRegister().getCashier().getTotalCost(vasya.getCart());

        assertEquals(expected, actual);
    }

    @Test
    void transactionTest() {
        Customer vasya = new Customer("Vasya", 0.05, 1000);
        vasya.setCart(new ArrayList<>(Arrays.asList(new Goods("t-shirt", EBrand.NIKE, EGroup.T_SHIRTS
                        , EDepartment.CLOTHES_DEPARTMENT, 200, "women's New Balance hoodie pink size 31"),
                new Goods("hoodie", EBrand.NEW_BALANCE, EGroup.HOODIES
                        , EDepartment.CLOTHES_DEPARTMENT, 300, "men's black slim t- shirt, size 38"),
                new Goods("Reebok sneakers", EBrand.REEBOK, EGroup.SHOES
                        , EDepartment.SHOES_DEPARTMENT, 500, "men's Reebok classic white sneakers, size 44"))));

        Check expected = new Check(vasya.getCart());
        Check actual = Shop.getCashRegister().getCashier().transaction(vasya);

        assertEquals(expected, actual);
    }
}