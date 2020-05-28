package shop.Interface;

import shop.Goods;
import shop.GoodsWrapper;
import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;
import shop.enums.ERole;

import java.util.List;

public interface IStoreKeeper {

    void receiveShipment(List<Goods> goods);

    List<Goods> get(EGroup group);

    List<Goods> get(EBrand brand);

    List<Goods> get(EDepartment department);

    int count(EBrand brand);

    int count(EGroup group);

    int count(EDepartment department);

    boolean isContains(EBrand brand);

    boolean isContains(EGroup group);

    boolean isContains(EDepartment department);

    Goods getGoods(String uniqueName);

    GoodsWrapper addGoods(Goods good);

    String generateUniqueName(Goods good);

    Goods transferToDepartment();


}
