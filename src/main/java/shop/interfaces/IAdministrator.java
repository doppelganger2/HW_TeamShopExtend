package shop.interfaces;

import shop.employee.Consultant;
import shop.employee.Employee;
import shop.enums.EDepartment;

public interface IAdministrator {

    void setConsultant(Consultant consultant, EDepartment department);

    Employee findFreeConsultant(EDepartment department);

    void transferConsultant(Consultant consultant, EDepartment eDepartment);
}
