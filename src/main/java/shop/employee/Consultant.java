package shop.employee;

import shop.Department;
import shop.enums.ERole;

import java.util.Objects;
import java.util.StringJoiner;

public class Consultant extends Employee{
    private Department department;

    public Consultant(String name, ERole role) {
        super(name, role);
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultant that = (Consultant) o;
        return Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Consultant.class.getSimpleName() + "[", "]")
                .add("department=" + department)
                .toString();
    }
}
