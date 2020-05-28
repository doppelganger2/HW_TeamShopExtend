package shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Check {
    private String token;
    private List<Goods> boughtGoods;

    public Check(List<Goods> customerCart) {
        this.boughtGoods = new ArrayList<>();
        this.token = TokenGenerator.generateToken(customerCart);
    }

    public String getToken() {
        return token;
    }

    public List<Goods> getBoughtGoods() {
        return boughtGoods;
    }

    public void setBoughtGoods(List<Goods> boughtGoods) {
        this.boughtGoods = boughtGoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return Objects.equals(token, check.token) &&
                Objects.equals(boughtGoods, check.boughtGoods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, boughtGoods);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Check.class.getSimpleName() + "[", "]")
                .add("token='" + token + "'")
                .add("boughtGoods=" + boughtGoods)
                .toString();
    }
}