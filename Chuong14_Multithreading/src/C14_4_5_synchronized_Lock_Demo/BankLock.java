package C14_4_5_synchronized_Lock_Demo;

import java.util.concurrent.locks.*;

public class BankLock implements Bank {
	private final double[] accounts;
    private final Lock bankLock = new ReentrantLock();
    private final Condition sufficientFunds = bankLock.newCondition();

    public BankLock(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < n; i++) accounts[i] = initialBalance;
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }
            accounts[from] -= amount;
            accounts[to] += amount;
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts) sum += a;
            return sum;
        } finally {
            bankLock.unlock();
        }
    }
}
