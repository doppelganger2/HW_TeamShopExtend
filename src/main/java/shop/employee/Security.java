package shop.employee;

import shop.Customer;
import shop.Interface.ISecurity;
import shop.TokenGenerator;
import shop.enums.ERole;

import java.util.Objects;
import java.util.StringJoiner;

public class Security extends Employee implements ISecurity {
    private String customerToken;

    public Security(String name, ERole role) {
        super(name, role);
    }

    @Override
    public boolean checkCustomer(Customer customer) {
        customerToken = TokenGenerator.generateToken(customer.getCart());
        return customer.getCheck().getToken().equals(this.customerToken);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Security security = (Security) o;
        return Objects.equals(customerToken, security.customerToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customerToken);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Security.class.getSimpleName() + "[", "]")
                .add("customerToken='" + customerToken + "'")
                .toString();
    }
}
