import java.util.*;

public class Counter extends Thread{
    private int temp = 0;

    public synchronized void increment(){
        temp++;
    }
    public int getTemp(){return temp;}
}

public class SysncDemo{
    public static void main(String[] arg)
    {
        Counter counter = new Counter();
        Thread t1 = new Thread(()->{
            for(int i = 0 ; i < 1000 ; i++)
                counter.increment();
        });

        Thread t2 = new Thread(()->{
            for (int i = 0 ; i < 1000 ; i++ )
                counter.increment();
        });
        t1.start();
        t2.start();
    try{
        t1.join();
        t2.join();
    }catch(InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Gia tri cuoi cung la" + counter.getTemp());
    }

}