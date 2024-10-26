package time;

import org.junit.Test;

public class test {

    private static int nextSerialNum = 0;

    private static ThreadLocal<Integer> serialNum = new ThreadLocal<>(){
        @Override
        protected synchronized Integer initialValue() {
            return nextSerialNum++;
        }
    };

    public static int getNextSerialNum(){
        return serialNum.get();
    }

    @Test
    public void serialTest(){
        for (int i = 0;i < 10;i++){
            Thread thread = new Thread(()->{
                System.out.println(test.getNextSerialNum());
                System.out.println(Thread.currentThread());
            });

            thread.start();
        }
    }
}
