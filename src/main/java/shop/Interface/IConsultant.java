package shop.Interface;

import shop.Goods;
import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;

import java.util.ArrayList;
import java.util.List;

public interface IConsultant {
    public List<Goods> giveAll();
    public List<Goods> giveByName(String name);
    public List<Goods> giveByGroup(EGroup group);
    public List<Goods> giveByBrands(EBrand brand);
    public List<Goods> giveByPrice(double startPrice, double finishPrice);
    public String generateUniqueName();
    public String giveInfoByName(String name);
}
