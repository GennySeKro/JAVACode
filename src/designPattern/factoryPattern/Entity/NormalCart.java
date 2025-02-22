package designPattern.factoryPattern.Entity;

import designPattern.factoryPattern.Service.Cart;
import designPattern.factoryPattern.Service.Product;

import java.util.HashMap;
import java.util.Map;

/*
普通购物车
 */
public class NormalCart implements Cart {

    private Map<Product, Integer> products = new HashMap<>();

    @Override
    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += product.getPrice() * quantity;
        }
        return totalPrice;
    }
}
