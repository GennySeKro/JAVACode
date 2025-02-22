package designPattern.observerPattern.observer.service;

/**
 * 主题接口，所有主题必须实现该接口
 */
public interface Subject {

    /*
    注册一个观察者
     */
    public void registerObserver(Observer observer);

    /*
    移除一个观者者
     */
    public void removeObserver(Observer observer);

    /*
    通知所有观察者
     */
    public void ontifyObserver();
}
