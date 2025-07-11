package C14_4_5_synchronized_Lock_Demo;

//  So sánh hiệu năng giữa sync và lock

public class Sync_Lock_Demo {
	private static final int ACCOUNTS = 100;
    private static final double INITIAL_BALANCE = 1000000;
    private static final int TRANSFERS = 100000;
    private static final int THREADS = 10;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Testing BankSync (synchronized)...");
        long syncTime = testBank(new BankSync(ACCOUNTS, INITIAL_BALANCE));

        System.out.println("\nTesting BankLock (ReentrantLock)...");
        long lockTime = testBank(new BankLock(ACCOUNTS, INITIAL_BALANCE));

        System.out.printf("\nBankSync time: %d ms\n", syncTime);
        System.out.printf("BankLock  time: %d ms\n", lockTime);
    }
    private static long testBank(Bank bank) throws InterruptedException {
        Thread[] threads = new Thread[THREADS];
        long start = System.currentTimeMillis();

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < TRANSFERS / THREADS; j++) {
                    int from = (int) (Math.random() * ACCOUNTS);
                    int to = (int) (Math.random() * ACCOUNTS);
                    if (from == to) continue; // tránh tự chuyển vào chính nó
                    double amount = Math.random() * 10; // chuyển ít tiền để tránh thiếu tiền
                    try {
                        bank.transfer(from, to, amount);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) t.join();

        long end = System.currentTimeMillis();
        return end - start;
    }
}
