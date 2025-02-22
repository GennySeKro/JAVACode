package designPattern.observerPattern.observer;

import designPattern.observerPattern.observer.service.Observer;
import designPattern.observerPattern.observer.service.Subject;

public class observerTwo implements Observer {

    private Subject subject;

    public observerTwo(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("observerTwo得到3D号码" + msg);
    }
}
