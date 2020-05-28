package shop.Interface;

import shop.employee.Consultant;
import shop.enums.EDepartment;

public interface IAdministrator {

    void setConsultant(Consultant consultant, EDepartment department);

    Consultant findFreeConsultant(EDepartment department);

    void transferConsultant(Consultant consultant, EDepartment eDepartment);
}
