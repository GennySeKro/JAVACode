package designPattern.observerPattern.observer;

import designPattern.observerPattern.observer.service.Observer;
import designPattern.observerPattern.observer.service.Subject;

public class observerOne implements Observer {

    private Subject subject;

    public observerOne(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }


    @Override
    public void update(String msg) {
        System.out.println("observerOne得到3D号码" + msg);
    }
}
