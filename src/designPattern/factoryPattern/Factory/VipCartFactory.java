package designPattern.factoryPattern.Factory;

import designPattern.factoryPattern.Entity.VipCart;
import designPattern.factoryPattern.Entity.VipProduct;
import designPattern.factoryPattern.Service.Cart;
import designPattern.factoryPattern.Service.CartFactory;
import designPattern.factoryPattern.Service.Product;


public class VipCartFactory implements CartFactory {
    @Override
    public Cart createCart() {
        return new VipCart();
    }

    @Override
    public Product createProduct(String name, int price) {
        return new VipProduct(name, price);
    }
}
