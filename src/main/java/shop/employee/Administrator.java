package shop.employee;

import shop.interfaces.IAdministrator;
import shop.Shop;
import shop.enums.EDepartment;
import shop.enums.ERole;

import java.util.NoSuchElementException;

public class Administrator extends Employee implements IAdministrator {

    public Administrator(String name, ERole role) {
        super(name, role);
    }

    @Override
    public void setConsultant(Consultant consultant, EDepartment department) {
        Shop.getDepartment(department).addConsultant(consultant);
        consultant.setDepartment(Shop.getDepartment(department));
    }

    @Override
    public Employee findFreeConsultant(EDepartment department) {
        return Shop.getDepartment(department).getConsultants().stream().filter(Employee::isFree)
                .findFirst().orElseThrow(() ->
                        new NoSuchElementException("All consultants are busy at this time"));
    }

    @Override
    public void transferConsultant(Consultant consultant, EDepartment targetDepartment) {
        Shop.getDepartment(targetDepartment).addConsultant(consultant);
    }
}
