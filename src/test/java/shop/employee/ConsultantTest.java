package shop.employee;

import org.junit.jupiter.api.Test;
import shop.Department;
import shop.Goods;
import shop.Shop;
import shop.Storage;
import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;
import shop.enums.ERole;
import shop.interfaces.IStoreKeeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConsultantTest {

    @Test
    void giveAllTest() {
        Consultant petya = new Consultant("Petya", ERole.CONSULTANT);
        Department clothes = new Department();
        Shop.createDepartment(EDepartment.CLOTHES_DEPARTMENT, clothes);
        Shop.administrator.setConsultant(petya,EDepartment.CLOTHES_DEPARTMENT);

        Goods good1 = new Goods("black hoodie",
                EBrand.REEBOK,
                EGroup.HOODIES,
                EDepartment.CLOTHES_DEPARTMENT,
                10.80,
                "Cool cotton hoodie");
        Goods good2 = new Goods("black shoes",
                EBrand.REEBOK,
                EGroup.SHOES,
                EDepartment.SHOES_DEPARTMENT,
                10.80,
                "Cool cotton shoes");
        Goods good3 = new Goods("yellow hoodie",
                EBrand.REEBOK,
                EGroup.HOODIES,
                EDepartment.CLOTHES_DEPARTMENT,
                11.80,
                "Cool cotton hoodie");
        clothes.addGoods(good1,good3);

        List<Goods> expected = new ArrayList<>(Arrays.asList(good1,good3));
        List<Goods> actual = petya.giveAll();

        assertEquals(expected, actual);
    }

    @Test
    void giveByNameTest() {
        Consultant petya = new Consultant("Petya", ERole.CONSULTANT);
        Department clothes = new Department();
        Shop.createDepartment(EDepartment.CLOTHES_DEPARTMENT, clothes);
        Shop.administrator.setConsultant(petya,EDepartment.CLOTHES_DEPARTMENT);

        Goods good1 = new Goods("black hoodie",
                EBrand.REEBOK,
                EGroup.HOODIES,
                EDepartment.CLOTHES_DEPARTMENT,
                10.80,
                "Cool cotton hoodie");
        Goods good2 = new Goods("black shoes",
                EBrand.REEBOK,
                EGroup.SHOES,
                EDepartment.SHOES_DEPARTMENT,
                10.80,
                "Cool cotton shoes");
        Goods good3 = new Goods("yellow hoodie",
                EBrand.REEBOK,
                EGroup.HOODIES,
                EDepartment.CLOTHES_DEPARTMENT,
                11.80,
                "Cool cotton hoodie");
        clothes.addGoods(good1,good3);

        List<Goods> expected = new ArrayList<>(Collections.singletonList(good3));
        List<Goods> actual = petya.giveByName("yellow hoodie");

        assertEquals(expected, actual);
    }

    @Test
    void giveByGroupTest() {
        Consultant petya = new Consultant("Petya", ERole.CONSULTANT);
        Department clothes = new Department();
        Shop.createDepartment(EDepartment.CLOTHES_DEPARTMENT, clothes);
        Shop.administrator.setConsultant(petya,EDepartment.CLOTHES_DEPARTMENT);

        Goods good1 = new Goods("black hoodie",
                EBrand.REEBOK,
                EGroup.HOODIES,
                EDepartment.CLOTHES_DEPARTMENT,
                10.80,
                "Cool cotton hoodie");
        Goods good2 = new Goods("black shoes",
                EBrand.REEBOK,
                EGroup.SHOES,
                EDepartment.SHOES_DEPARTMENT,
                10.80,
                "Cool cotton shoes");
        Goods good3 = new Goods("yellow hoodie",
                EBrand.REEBOK,
                EGroup.HOODIES,
                EDepartment.CLOTHES_DEPARTMENT,
                11.80,
                "Cool cotton hoodie");
        clothes.addGoods(good1,good3);

        List<Goods> expected = new ArrayList<>(Arrays.asList(good1, good3));
        List<Goods> actual = petya.giveByGroup(EGroup.HOODIES);

        assertEquals(expected, actual);
    }

    @Test
    void giveByBrandsTest() {
        Consultant petya = new Consultant("Petya", ERole.CONSULTANT);
        Department clothes = new Department();
        Shop.createDepartment(EDepartment.CLOTHES_DEPARTMENT, clothes);
        Shop.administrator.setConsultant(petya,EDepartment.CLOTHES_DEPARTMENT);

        Goods good1 = new Goods("black hoodie",
                EBrand.REEBOK,
                EGroup.HOODIES,
                EDepartment.CLOTHES_DEPARTMENT,
                10.80,
                "Cool cotton hoodie");
        Goods good2 = new Goods("black shoes",
                EBrand.REEBOK,
                EGroup.SHOES,
                EDepartment.SHOES_DEPARTMENT,
                10.80,
                "Cool cotton shoes");
        Goods good3 = new Goods("yellow hoodie",
                EBrand.REEBOK,
                EGroup.HOODIES,
                EDepartment.CLOTHES_DEPARTMENT,
                11.80,
                "Cool cotton hoodie");
        clothes.addGoods(good1,good3);

        List<Goods> expected = new ArrayList<>(Arrays.asList(good1, good3));
        List<Goods> actual = petya.giveByBrands(EBrand.REEBOK);

        assertEquals(expected, actual);
    }

    @Test
    void giveByPriceTest() {
        Consultant petya = new Consultant("Petya", ERole.CONSULTANT);
        Department clothes = new Department();
        Shop.createDepartment(EDepartment.CLOTHES_DEPARTMENT, clothes);
        Shop.administrator.setConsultant(petya,EDepartment.CLOTHES_DEPARTMENT);

        Goods good1 = new Goods("black hoodie",
                EBrand.REEBOK,
                EGroup.HOODIES,
                EDepartment.CLOTHES_DEPARTMENT,
                10.80,
                "Cool cotton hoodie");
        Goods good2 = new Goods("black shoes",
                EBrand.REEBOK,
                EGroup.SHOES,
                EDepartment.SHOES_DEPARTMENT,
                10.80,
                "Cool cotton shoes");
        Goods good3 = new Goods("yellow hoodie",
                EBrand.REEBOK,
                EGroup.HOODIES,
                EDepartment.CLOTHES_DEPARTMENT,
                11.80,
                "Cool cotton hoodie");
        clothes.addGoods(good1,good3);

        List<Goods> expected = new ArrayList<>(Arrays.asList(good1, good3));
        List<Goods> actual = petya.giveByPrice(10, 12);

        assertEquals(expected, actual);
    }

    @Test
    void giveInfoByNameTest() {
        Consultant petya = new Consultant("Petya", ERole.CONSULTANT);
        Department clothes = new Department();
        Shop.createDepartment(EDepartment.CLOTHES_DEPARTMENT, clothes);
        Shop.administrator.setConsultant(petya,EDepartment.CLOTHES_DEPARTMENT);

        Goods good1 = new Goods("black hoodie",
                EBrand.REEBOK,
                EGroup.HOODIES,
                EDepartment.CLOTHES_DEPARTMENT,
                10.80,
                "Cool cotton hoodie");
        Goods good2 = new Goods("black shoes",
                EBrand.REEBOK,
                EGroup.SHOES,
                EDepartment.SHOES_DEPARTMENT,
                10.80,
                "Cool cotton shoes");
        Goods good3 = new Goods("yellow hoodie",
                EBrand.REEBOK,
                EGroup.HOODIES,
                EDepartment.CLOTHES_DEPARTMENT,
                11.80,
                "Cool cotton hoodie");
        clothes.addGoods(good1,good3);

        String expected = "Cool cotton hoodie";
        String actual = petya.giveInfoByName("yellow hoodie");

        assertEquals(expected, actual);
    }
}