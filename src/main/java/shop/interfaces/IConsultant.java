package shop.interfaces;

import shop.Goods;
import shop.enums.EBrand;
import shop.enums.EGroup;

import java.util.List;

public interface IConsultant {

    public List<Goods> giveAll();

    public List<Goods> giveByName(String name);

    public List<Goods> giveByGroup(EGroup group);

    public List<Goods> giveByBrands(EBrand brand);

    public List<Goods> giveByPrice(double startPrice, double finishPrice);

    public String giveInfoByName(String name);
}
