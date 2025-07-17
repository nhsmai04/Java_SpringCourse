public class TwoCounters {
    private long c1 = 0, c2 = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void inc1() {
        synchronized(lock1) {
            c1++;
        }
    }

    public void inc2() {
        synchronized(lock2) {
            c2++;
        }
    }

    public long getC1() {
        return c1;
    }

    public long getC2() {
        return c2;
    }

    public static void main(String[] args) {
        TwoCounters counters = new TwoCounters();

        // Thread tăng c1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counters.inc1();
            }
        });
        Thread t11 = new Thread(() -> {
            for (int i =0 ; i < 100000 ;i++)
            {
                counters.inc1();
            }
        });
        // Thread tăng c2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counters.inc2();
            }
        });

        // Thread tăng cả c1 và c2
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counters.inc1();
                counters.inc2();
            }
        });

        // Khởi động tất cả
        t1.start();
        t11.start();
        t2.start();
        t3.start();

        // Chờ tất cả thread kết thúc
        try {
            t1.join();
            t11.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // In kết quả cuối cùng
        System.out.println("Giá trị cuối cùng của c1: " + counters.getC1());
        System.out.println("Giá trị cuối cùng của c2: " + counters.getC2());
    }
}
