package shop;

import java.util.List;

public class TokenGenerator {
    public static String generateToken(List<Goods> cart){
        String token = "";
        for (Goods goods : cart)
        {
            token = token + goods.getBrand().toString();
            token = goods.getUniqueName() + token;
            token = goods.getDepartment() + token;
            token = token + cart.hashCode();
        }
        return token;
    }
}
