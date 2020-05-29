package shop.employee;

import shop.Goods;
import shop.GoodsWrapper;
import shop.interfaces.IStoreKeeper;
import shop.Storage;
import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;
import shop.enums.ERole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StoreKeeper extends Employee implements IStoreKeeper {
    private Map<EBrand, Integer> brandCount;
    private Map<EGroup, Integer> groupCount;
    private Map<EDepartment, Integer> departmentCount;

    public StoreKeeper(String name, ERole role) {
        super(name, role);
        brandCount = new HashMap<>();
        groupCount = new HashMap<>();
        departmentCount = new HashMap<>();
    }

    public void updateCounters() {
        brandCount.clear();
        for (EBrand eBrand : EBrand.values()) {
            brandCount.put(eBrand, sumOfGoodsByParam(eBrand));
        }

        groupCount.clear();
        for (EGroup eGroup : EGroup.values()) {
            groupCount.put(eGroup, sumOfGoodsByParam(eGroup));
        }

        departmentCount.clear();
        for (EDepartment eDepartment : EDepartment.values()) {
            departmentCount.put(eDepartment, sumOfGoodsByParam(eDepartment));
        }
    }

    private int sumOfGoodsByParam(EBrand brand) {
        int result = 0;

        for (GoodsWrapper goodsWrapper : Storage.getGoodsMap().values()) {

            if (goodsWrapper.getGoods().getBrand().equals(brand)) {
                result += goodsWrapper.getCount();
            }
        }
        return result;
    }

    private int sumOfGoodsByParam(EGroup group) {
        int result = 0;

        for (GoodsWrapper goodsWrapper : Storage.getGoodsMap().values()) {

            if (goodsWrapper.getGoods().getGroup().equals(group)) {
                result += goodsWrapper.getCount();
            }
        }
        return result;
    }

    private int sumOfGoodsByParam(EDepartment department) {
        int result = 0;

        for (GoodsWrapper goodsWrapper : Storage.getGoodsMap().values()) {

            if (goodsWrapper.getGoods().getDepartment().equals(department)) {
                result += goodsWrapper.getCount();
            }
        }
        return result;
    }

    @Override
    public void receiveShipment(List<Goods> goods) {

        for (Goods good : goods) {
            addGoods(good);
        }
        updateCounters();
    }

    @Override
    public List<Goods> get(EGroup group) {
        List<Goods> result = new ArrayList<>();

        List<GoodsWrapper> temp = Storage.getGoodsMap().values().stream().
                filter(goodsWrapper -> goodsWrapper.getGoods().
                        getGroup().equals(group)).collect(Collectors.toList());

        temp.forEach(goodsWrapper -> result.add(goodsWrapper.getGoods()));
        return result;
    }

    @Override
    public List<Goods> get(EBrand brand) {
        List<Goods> result = new ArrayList<>();

        List<GoodsWrapper> temp = Storage.getGoodsMap().values().stream().
                filter(goodsWrapper -> goodsWrapper.getGoods().
                        getBrand().equals(brand)).collect(Collectors.toList());

        temp.forEach(goodsWrapper -> result.add(goodsWrapper.getGoods()));
        return result;
    }

    @Override
    public List<Goods> get(EDepartment department) {
        List<Goods> result = new ArrayList<>();

        List<GoodsWrapper> temp = Storage.getGoodsMap().values().stream().
                filter(goodsWrapper -> goodsWrapper.getGoods().
                        getDepartment().equals(department)).collect(Collectors.toList());

        temp.forEach(goodsWrapper -> result.add(goodsWrapper.getGoods()));
        return result;
    }

    @Override
    public int count(EBrand brand) {
        return brandCount.get(brand);
    }

    @Override
    public int count(EGroup group) {
        return groupCount.get(group);
    }

    @Override
    public int count(EDepartment department) {
        return departmentCount.get(department);
    }

    @Override
    public boolean isContains(EBrand brand) {
        for (GoodsWrapper goodsWrapper : Storage.getGoodsMap().values()) {

            if (goodsWrapper.getGoods().getBrand().equals(brand)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isContains(EGroup group) {
        for (GoodsWrapper goodsWrapper : Storage.getGoodsMap().values()) {

            if (goodsWrapper.getGoods().getGroup().equals(group)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isContains(EDepartment department) {
        for (GoodsWrapper goodsWrapper : Storage.getGoodsMap().values()) {

            if (goodsWrapper.getGoods().getDepartment().equals(department)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Goods getGoods(String uniqueName) {
        return Storage.getGoodsMap().get(uniqueName).getGoods();
    }

    @Override
    public GoodsWrapper addGoods(Goods good) {
        if (Storage.getGoodsMap().containsKey(generateUniqueName(good))) {
            Storage.getGoodsMap().get(generateUniqueName(good)).addOne();
        } else {
            Storage.getGoodsMap().put(generateUniqueName(good), new GoodsWrapper(good, 1));
        }
        return Storage.getGoodsMap().get(generateUniqueName(good));
    }

    @Override
    public String generateUniqueName(Goods good) {

        for (GoodsWrapper goodsWrapper : Storage.getGoodsMap().values()) {

            if (goodsWrapper.getGoods().equals(good)) {
                return good.getUniqueName();
            } else throw new NoSuchFieldError("There is no product in storage matching the search criteria");
        }
        return null;
    }

    @Override
    public Goods transferToDepartment(String uniqueName) {

        if (Storage.getGoodsMap().containsKey(uniqueName)) {
            if (Storage.getGoodsMap().get(uniqueName).removeOne() == null) {
                throw new NoSuchFieldError("There is no product in storage matching the search criteria");
            }
            Storage.getGoodsMap().get(uniqueName).removeOne();
            updateCounters();
            return Storage.getGoodsMap().get(uniqueName).getGoods();
        }
        return null;
    }

    @Override
    public Goods transferToDepartment(Goods goods) {
        return transferToDepartment(generateUniqueName(goods));
    }
}
