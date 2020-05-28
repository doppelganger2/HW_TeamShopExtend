package shop.Interface;

import shop.employee.Consultant;
import shop.employee.Employee;
import shop.enums.EDepartment;

import java.util.Optional;

public interface IAdministrator {

    void setConsultant(Consultant consultant, EDepartment department);

    Optional<Employee> findFreeConsultant(EDepartment department);

    void transferConsultant(Consultant consultant, EDepartment eDepartment);
}
