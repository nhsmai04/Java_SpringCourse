package C14_4_5_synchronized_Lock_Demo;

public class BankSync implements Bank {
	private final double[] accounts;

    public BankSync(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < n; i++) accounts[i] = initialBalance;
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) {
            wait();
        }
        accounts[from] -= amount;
        accounts[to] += amount;
        notifyAll();
    }

    public synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) sum += a;
        return sum;
    }
}
