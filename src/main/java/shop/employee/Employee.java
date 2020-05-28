package shop.employee;

import shop.Interface.IEmployee;
import shop.enums.ERole;

import java.util.Objects;
import java.util.StringJoiner;

public class Employee implements IEmployee {
    private static long staticID = 0;
    private long id;
    private String name;
    private ERole role;
    private boolean isFree = true;

    public Employee(String name, ERole role) {
        this.id = ++staticID;
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public ERole getRole() {
        return role;
    }

    public boolean isFree() {
        return isFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                isFree == employee.isFree &&
                Objects.equals(name, employee.name) &&
                Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, isFree);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("role=" + role)
                .add("isFree=" + isFree)
                .toString();
    }
}
