package shop.employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.Customer;
import shop.Department;
import shop.Goods;
import shop.Shop;
import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;
import shop.enums.ERole;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorTest {

    @Test
    void setConsultantTest() {
        Consultant petya = new Consultant("Petya", ERole.CONSULTANT);
        Consultant kolya = new Consultant("Kolya", ERole.CONSULTANT);
        Consultant anton = new Consultant("Anton", ERole.CONSULTANT);

        Department clothes = new Department();
        Department shoes = new Department();
        Shop.createDepartment(EDepartment.CLOTHES_DEPARTMENT, clothes);
        Shop.createDepartment(EDepartment.SHOES_DEPARTMENT, shoes);

        Shop.administrator.setConsultant(petya, EDepartment.CLOTHES_DEPARTMENT);
        Shop.administrator.setConsultant(kolya, EDepartment.SHOES_DEPARTMENT);
        Shop.administrator.setConsultant(anton, EDepartment.CLOTHES_DEPARTMENT);

        List<Employee> expected = new ArrayList<>(Arrays.asList(petya, anton));
        List<Employee> actual = Shop.getDepartment(EDepartment.CLOTHES_DEPARTMENT).getConsultants();

        assertEquals(expected, actual);
    }

    @Test
    void findFreeConsultantTest() {
        Consultant petya = new Consultant("Petya", ERole.CONSULTANT);
        Consultant kolya = new Consultant("Kolya", ERole.CONSULTANT);
        Consultant anton = new Consultant("Anton", ERole.CONSULTANT);

        Department clothes = new Department();
        Department shoes = new Department();
        Shop.createDepartment(EDepartment.CLOTHES_DEPARTMENT, clothes);
        Shop.createDepartment(EDepartment.SHOES_DEPARTMENT, shoes);

        Shop.administrator.setConsultant(petya, EDepartment.CLOTHES_DEPARTMENT);
        Shop.administrator.setConsultant(kolya, EDepartment.SHOES_DEPARTMENT);
        Shop.administrator.setConsultant(anton, EDepartment.CLOTHES_DEPARTMENT);

        Employee expected = petya;
        Employee actual = Shop.administrator.findFreeConsultant(EDepartment.CLOTHES_DEPARTMENT);

        assertEquals(expected, actual);
    }

    @Test
    void transferConsultantTest() {
//        Consultant petya = new Consultant("Petya", ERole.CONSULTANT);
//        Consultant kolya = new Consultant("Kolya", ERole.CONSULTANT);
//        Consultant anton = new Consultant("Anton", ERole.CONSULTANT);
//
//        Department clothes = new Department();
//        Department shoes = new Department();
//        Shop.createDepartment(EDepartment.CLOTHES_DEPARTMENT, clothes);
//        Shop.createDepartment(EDepartment.SHOES_DEPARTMENT, shoes);
//
//        Shop.administrator.setConsultant(petya, EDepartment.CLOTHES_DEPARTMENT);
//        Shop.administrator.setConsultant(kolya, EDepartment.SHOES_DEPARTMENT);
//        Shop.administrator.setConsultant(anton, EDepartment.CLOTHES_DEPARTMENT);
//
//        List<Employee> expected = new ArrayList<>(Collections.singletonList(petya));
//        Shop.administrator.transferConsultant(anton, EDepartment.SHOES_DEPARTMENT);
//        List<Employee> actual = Shop.getDepartment(EDepartment.SHOES_DEPARTMENT).getConsultants();
//
//        assertEquals(expected, actual);
    }
}