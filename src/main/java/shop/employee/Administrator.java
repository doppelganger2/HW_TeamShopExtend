package shop.employee;

import shop.Interface.IAdministrator;
import shop.Shop;
import shop.enums.EDepartment;
import shop.enums.ERole;

import java.util.Optional;

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
    public Optional<Employee> findFreeConsultant(EDepartment department) {
        return Shop.getDepartment(department).getConsultants().stream().filter(Employee::isFree).findFirst();
    }

    @Override
    public void transferConsultant(Consultant consultant, EDepartment targetDepartment) {
        Shop.getDepartment(targetDepartment).addConsultant(consultant);
    }
}
