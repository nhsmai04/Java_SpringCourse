import java.util.*;
class ShareResource{
    private boolean ready = false;

    public synchronized void produce(){
        ready=true;
        System.out.println("Product is ready for sale ");
        notify();
    }
    public synchronized void consume(){
        while(!ready)
        {
            try{
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Consumed data");
    }

}
public class ProCon{
    public static void main(String[] arg)
    {
        ShareResource resource = new ShareResource();
        Thread producer = new Thread(()->{
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            resource.produce();
        });
        Thread consumer = new Thread(()-> {
            resource.consume();
        });
        consumer.start();
        producer.start();
    }
}