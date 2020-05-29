package shop.employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.Goods;
import shop.GoodsWrapper;
import shop.Storage;
import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;
import shop.enums.ERole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreKeeperTest {

    @Test
    void getByGroup() {
        Goods good1 = new Goods("black hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 10.80, "Cool cotton hoodie");
        Goods good2 = new Goods("black shoes", EBrand.REEBOK, EGroup.SHOES, EDepartment.CLOTHES_DEPARTMENT, 10.80, "Cool cotton shoes");
        Goods good3 = new Goods("yellow hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 11.80, "Cool cotton hoodie");

        StoreKeeper testStoreKeeper = new StoreKeeper("Vasya", ERole.STORE_KEEPER);
        testStoreKeeper.addGoods(good1);
        testStoreKeeper.addGoods(good2);
        testStoreKeeper.addGoods(good3);

        List<Goods> actual = testStoreKeeper.get(EGroup.HOODIES);

        List<Goods> expected = new ArrayList<Goods>();
        expected.add(good1);
        expected.add(good3);

        assertEquals(expected, actual);
    }

    @Test
    void getByBrand() {
        Goods good1 = new Goods("black hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 10.80, "Cool cotton hoodie");
        Goods good2 = new Goods("black shoes", EBrand.REEBOK, EGroup.SHOES, EDepartment.CLOTHES_DEPARTMENT, 10.80, "Cool cotton shoes");
        Goods good3 = new Goods("yellow hoodie", EBrand.NIKE, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 11.80, "Cool cotton hoodie");

        StoreKeeper testStoreKeeper = new StoreKeeper("Vasya", ERole.STORE_KEEPER);
        testStoreKeeper.addGoods(good1);
        testStoreKeeper.addGoods(good2);
        testStoreKeeper.addGoods(good3);

        List<Goods> actual = testStoreKeeper.get(EBrand.REEBOK);

        List<Goods> expected = new ArrayList<Goods>();
        expected.add(good1);
        expected.add(good2);

        assertEquals(expected, actual);
    }

    @Test
    void getByDepartment() {
        Goods good1 = new Goods("black hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 10.80, "Cool cotton hoodie");
        Goods good2 = new Goods("black shoes", EBrand.REEBOK, EGroup.SHOES, EDepartment.SHOES_DEPARTMENT, 10.80, "Cool cotton shoes");
        Goods good3 = new Goods("yellow hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 11.80, "Cool cotton hoodie");

        StoreKeeper testStoreKeeper = new StoreKeeper("Vasya", ERole.STORE_KEEPER);
        testStoreKeeper.addGoods(good1);
        testStoreKeeper.addGoods(good2);
        testStoreKeeper.addGoods(good3);

        List<Goods> actual = testStoreKeeper.get(EDepartment.SHOES_DEPARTMENT);

        List<Goods> expected = new ArrayList<Goods>();
        expected.add(good2);

        assertEquals(expected, actual);
    }

    @Test
    void isContainsByGroup() {
        Goods good1 = new Goods("black hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 10.80, "Cool cotton hoodie");
        Goods good2 = new Goods("black shoes", EBrand.REEBOK, EGroup.SHOES, EDepartment.SHOES_DEPARTMENT, 10.80, "Cool cotton shoes");
        Goods good3 = new Goods("yellow hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 11.80, "Cool cotton hoodie");

        StoreKeeper testStoreKeeper = new StoreKeeper("Vasya", ERole.STORE_KEEPER);
        testStoreKeeper.addGoods(good1);
        testStoreKeeper.addGoods(good2);
        testStoreKeeper.addGoods(good3);

        boolean expected = testStoreKeeper.isContains(EGroup.SHOES);

        assertTrue(expected);
    }

    @Test
    void isContainsByBrand() {
        Goods good1 = new Goods("black hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 10.80, "Cool cotton hoodie");
        Goods good2 = new Goods("black shoes", EBrand.REEBOK, EGroup.SHOES, EDepartment.SHOES_DEPARTMENT, 10.80, "Cool cotton shoes");
        Goods good3 = new Goods("yellow hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 11.80, "Cool cotton hoodie");

        StoreKeeper testStoreKeeper = new StoreKeeper("Vasya", ERole.STORE_KEEPER);
        testStoreKeeper.addGoods(good1);
        testStoreKeeper.addGoods(good2);
        testStoreKeeper.addGoods(good3);

        boolean expected = testStoreKeeper.isContains(EBrand.REEBOK);

        assertTrue(expected);
    }

    @Test
    void isContainsByDepartment() {
        Goods good1 = new Goods("black hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 10.80, "Cool cotton hoodie");
        Goods good2 = new Goods("black shoes", EBrand.REEBOK, EGroup.SHOES, EDepartment.SHOES_DEPARTMENT, 10.80, "Cool cotton shoes");
        Goods good3 = new Goods("yellow hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 11.80, "Cool cotton hoodie");

        StoreKeeper testStoreKeeper = new StoreKeeper("Vasya", ERole.STORE_KEEPER);
        testStoreKeeper.addGoods(good1);
        testStoreKeeper.addGoods(good2);
        testStoreKeeper.addGoods(good3);

        boolean expected = testStoreKeeper.isContains(EDepartment.CLOTHES_DEPARTMENT);

        assertTrue(expected);
    }

    @Test
    void generateUniqueName() {
        Goods goods = new Goods("black hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 10.80, "Cool cotton hoodie");
        StoreKeeper testStoreKeeper = new StoreKeeper("Vasya", ERole.STORE_KEEPER);

        String expected = "black hoodie REEBOK HOODIES";

        String actual = testStoreKeeper.generateUniqueName(goods);

        assertEquals(expected, actual);
    }

    @Test
    void generateUniqueNameNull() {
        Goods goods = null;
        StoreKeeper testStoreKeeper = new StoreKeeper("Vasya", ERole.STORE_KEEPER);

        String expected = null;

        String actual = testStoreKeeper.generateUniqueName(goods);

        assertEquals(expected, actual);
    }

    @Test
    void transferToDepartmentTest() {
        Goods good1 = new Goods("black hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 10.80, "Cool cotton hoodie");
        Goods good2 = new Goods("black shoes", EBrand.REEBOK, EGroup.SHOES, EDepartment.SHOES_DEPARTMENT, 10.80, "Cool cotton shoes");
        Goods good3 = new Goods("yellow hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 11.80, "Cool cotton hoodie");
        Goods good4 = new Goods("black hoodie", EBrand.REEBOK, EGroup.HOODIES, EDepartment.CLOTHES_DEPARTMENT, 10.80, "Cool cotton hoodie");

        StoreKeeper testStoreKeeper = new StoreKeeper("Vasya", ERole.STORE_KEEPER);
        testStoreKeeper.addGoods(good1);
        testStoreKeeper.addGoods(good2);
        testStoreKeeper.addGoods(good3);
        testStoreKeeper.addGoods(good4);

        Goods expected = good1;

        Goods actual = testStoreKeeper.transferToDepartment("black hoodie REEBOK HOODIES");

        assertEquals(expected, actual);
    }
}