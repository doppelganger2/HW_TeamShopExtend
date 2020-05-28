package shop;

import shop.employee.IEmployee;
import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;

import java.util.List;
import java.util.Map;

public class Storage {
    Map<String,GoodsWraper> goodsMap;
    List<EBrand> brands;
    List<EGroup> groups;
    List<EDepartment> departments;
    IEmployee storeKeeper;
}
