package designPattern.observerPattern.observer.serviceImpl;

import designPattern.observerPattern.entity.Lottery;
import designPattern.observerPattern.observer.service.Observer;
import designPattern.observerPattern.observer.service.Subject;

import java.util.ArrayList;
import java.util.List;

public class ObjectFor3D implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    /*
    3D彩票的号码
     */
    private Lottery lottery = new Lottery();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index > 0){
            observers.remove(index);
        }
    }

    @Override
    public void ontifyObserver() {
        for (Observer observer : observers){
            observer.update(lottery.getMsg());
        }
    }

    public void setMsg(String msg){
        this.lottery.setMsg(msg);
        ontifyObserver();
    }
}
