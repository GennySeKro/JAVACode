package designPattern.observerPattern.observer.service;

/**
 * 所有观察者必须实现此接口
 */
public interface Observer {

    public void update(String msg);
}
