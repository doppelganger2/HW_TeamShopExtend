package shop;

import java.util.Objects;
import java.util.StringJoiner;

public class GoodsWrapper {

    Goods goods;
    int count;

    public GoodsWrapper(Goods goods, int count) {
        this.goods = goods;
        this.count = count;
    }

    public Goods getGoods() {
        return goods;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsWrapper that = (GoodsWrapper) o;
        return count == that.count &&
                Objects.equals(goods, that.goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goods, count);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GoodsWrapper.class.getSimpleName() + "[", "]")
                .add("goods=" + goods)
                .add("count=" + count)
                .toString();
    }
}
