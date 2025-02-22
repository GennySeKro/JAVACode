package designPattern.factoryPattern.Entity;

import designPattern.factoryPattern.Service.Product;

/*
VIP商品
 */
public class VipProduct implements Product {

    private String name;

    private int price;

    public VipProduct(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
