package shop;

import shop.employee.Consultant;
import shop.employee.Employee;
import shop.enums.EBrand;

import java.util.*;


public class Department {
    List<EBrand> brands = new ArrayList<>();
    List<Goods> goods = new ArrayList<>();
    List<Employee> consultants = new ArrayList<>();

    public Department() {
    }

    public List<EBrand> getBrands() {
        return brands;
    }


    public List<Goods> getGoods() {
        return goods;
    }

    public List<Employee> getConsultants() {
        return consultants;
    }

    public void addConsultant(Consultant consultant) {
        this.consultants.add(consultant);
    }

    public void removeConsultant(Employee consultant) {
        this.consultants.remove(consultant);
    }

    public void addGoods(Goods... goods) {
        this.goods.addAll(Arrays.asList(goods));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(brands, that.brands) &&
                Objects.equals(goods, that.goods) &&
                Objects.equals(consultants, that.consultants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brands, goods, consultants);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Department.class.getSimpleName() + "[", "]")
                .add("brands=" + brands)
                .add("goods=" + goods)
                .add("consultants=" + consultants)
                .toString();
    }
}
