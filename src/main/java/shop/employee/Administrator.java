package shop.employee;

import shop.Interface.IAdministrator;
import shop.Shop;
import shop.enums.EDepartment;

public class Administrator extends Employee implements IAdministrator {

    @Override
    public void setConsultant(Consultant consultant, EDepartment department) {
        Shop.getDepartment(department).addConsultant(consultant);
        consultant.setDepartment(Shop.getDepartment(department));
    }

    @Override
    public Consultant findFreeConsultant(EDepartment department) {
        return null;
    }

    @Override
    public void transferConsultant(Consultant consultant, EDepartment department) {

    }
}
