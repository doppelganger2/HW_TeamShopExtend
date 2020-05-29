package shop.employee;

import shop.enums.ERole;
import shop.interfaces.IEmployee;

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

    public long getId() {
        return id;
    }

    public ERole getRole() {
        return role;
    }

    public boolean isFree() {
        return isFree;
    }

    @Override
    public boolean equals(Employee e) {
        return this.getId() == e.getId();
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
