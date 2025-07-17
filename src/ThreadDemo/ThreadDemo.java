import java.util.*;

public class Mythread extends Thread{
    @Override
    public void run() {
        for(int i = 0 ; i<= 5 ;i++)
        System.out.println("My Thread: " + i);

    }
}
public class ThreadDemo{
    public static void main (String[] arg)
    {
        Mythread t1 = new Mythread();


        Thread t2 = new Thread(()->{
            for(int i = 6; i <= 10 ;i++)
                System.out.println("Next Thread" + i);
        });
        t2.start();
        t1.start();
    }
}