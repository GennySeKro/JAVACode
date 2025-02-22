package designPattern.factoryPattern.Factory;

import designPattern.factoryPattern.Entity.NormalCart;
import designPattern.factoryPattern.Entity.NormalProduct;
import designPattern.factoryPattern.Service.Cart;
import designPattern.factoryPattern.Service.CartFactory;
import designPattern.factoryPattern.Service.Product;

/*
普通购物车工厂
 */
public class NormalCartFactory implements CartFactory {
    @Override
    public Cart createCart() {
        return new NormalCart();
    }

    @Override
    public Product createProduct(String name, int price) {
        return new NormalProduct(name, price);
    }
}
