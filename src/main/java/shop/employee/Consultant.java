package shop.Employee;

import shop.Department;
import shop.Goods;
import shop.Interface.IConsultant;
import shop.enums.EBrand;
import shop.enums.EGroup;

import java.util.ArrayList;
import java.util.List;

public class Consultant implements IConsultant {
    Department department;

    @Override
    public List<Goods> giveAll() {
        return department.getGoods();
    }

    @Override
    public List<Goods> giveByName(String name) {
        ArrayList<Goods> suggestedGoods = new ArrayList<Goods>();
        for (Goods goods : giveAll()) {
            if (goods.getName().equals(name)){
                suggestedGoods.add(goods);
            }
        }

        return suggestedGoods;
    }

    @Override
    public List<Goods> giveByGroup(EGroup group) {
        ArrayList<Goods> suggestedGoods = new ArrayList<Goods>();
        for (Goods goods : giveAll()) {
            if (goods.getGroup().equals(group)){
                suggestedGoods.add(goods);
            }
        }

        return suggestedGoods;
    }

    @Override
    public List<Goods> giveByBrands(EBrand brand) {
        ArrayList<Goods> suggestedGoods = new ArrayList<Goods>();
        for (Goods goods : giveAll()) {
            if (goods.getBrand().equals(brand)){
                suggestedGoods.add(goods);
            }
        }

        return suggestedGoods;
    }

    @Override
    public List<Goods> giveByPrice(double startPrice, double finishPrice) {
        ArrayList<Goods> suggestedGoods = new ArrayList<Goods>();
        for (Goods goods : giveAll()) {
            if (goods.getPrice() >= startPrice && goods.getPrice() <= finishPrice){
                suggestedGoods.add(goods);
            }
        }

        return suggestedGoods;
    }

    @Override
    public String generateUniqueName() {
        return null;
    }

    @Override
    public String giveInfoByName(String name) {
        for (Goods goods : giveAll()) {
            if (goods.getName().equals(name)){
                return goods.getInfo();
            }
        }
        return "Sorry, we don't have product with this name";

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
