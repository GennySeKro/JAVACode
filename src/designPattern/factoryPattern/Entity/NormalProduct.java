package designPattern.factoryPattern.Entity;

import designPattern.factoryPattern.Service.Product;

public class NormalProduct implements Product {

    private String name;

    private int price;

    public NormalProduct(String name, int price) {
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
