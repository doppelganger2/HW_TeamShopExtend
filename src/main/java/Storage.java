import Employee.Employee;
import enums.EBrand;
import enums.EDepartment;
import enums.EGroup;

import java.util.List;
import java.util.Map;

public class Storage {
    Map<String,GoodsWraper> goodsMap;
    List<EBrand> brands;
    List<EGroup> groups;
    List<EDepartment> departments;
    Employee storeKeeper;
}
