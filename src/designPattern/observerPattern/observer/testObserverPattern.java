package designPattern.observerPattern.observer;

import designPattern.observerPattern.observer.service.Observer;
import designPattern.observerPattern.observer.serviceImpl.ObjectFor3D;
import org.junit.Test;

public class testObserverPattern {


    @Test
    public void test(){
        ObjectFor3D for3D = new ObjectFor3D();

        Observer observerOne = new observerOne(for3D);
        Observer observerTwo = new observerTwo(for3D);

        for3D.setMsg("123");
    }
}
