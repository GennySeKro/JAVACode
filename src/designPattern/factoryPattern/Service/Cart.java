package designPattern.factoryPattern.Service;

/*
购物车接口
 */
public interface Cart {

    void addProduct(Product product, int quantity);

    void removeProduct(Product product);

    double getTotalPrice();
}
