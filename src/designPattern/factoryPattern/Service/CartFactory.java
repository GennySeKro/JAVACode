package designPattern.factoryPattern.Service;

/*
抽象工厂接口
 */
public interface CartFactory {

    Cart createCart();

    Product createProduct(String name, int price);
}
