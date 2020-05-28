package shop;


import shop.employee.Employee;
import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;

import java.util.List;
import java.util.Map;

public class Storage {
    Map<String, GoodsWrapper> goodsMap;
    List<EBrand> brands;
    List<EGroup> groups;
    List<EDepartment> departments;
    Employee storeKeeper;
}
