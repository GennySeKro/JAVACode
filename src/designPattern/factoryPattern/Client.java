package designPattern.factoryPattern;

import designPattern.factoryPattern.Entity.VipCart;
import designPattern.factoryPattern.Factory.NormalCartFactory;
import designPattern.factoryPattern.Factory.VipCartFactory;
import designPattern.factoryPattern.Service.Cart;
import designPattern.factoryPattern.Service.CartFactory;
import designPattern.factoryPattern.Service.Product;
import org.junit.Test;

public class Client {

    @Test
    public void test(){

        CartFactory normalCartFactory = new NormalCartFactory();
        Cart normalCart = normalCartFactory.createCart();

        Product normalProduct = normalCartFactory.createProduct("普通商品", 100);
        normalCart.addProduct(normalProduct, 1);
        System.out.println("普通购物车总价：" + normalCart.getTotalPrice());

        CartFactory vipCartFactory = new VipCartFactory();
        VipCart vipCart = (VipCart) vipCartFactory.createCart();
        Product vipProduct = vipCartFactory.createProduct("VIP商品", 200);
        vipCart.addProduct(vipProduct, 1);

        vipCart.addPoints(100);
        vipCart.useCoupon("VIP优惠券");
        System.out.println("VIP购物车总价：" + vipCart.getTotalPrice());
    }
}
