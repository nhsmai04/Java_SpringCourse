package C14_4_5_synchronized_Lock_Demo;

interface Bank {
	void transfer(int from, int to, double amount) throws InterruptedException;
    double getTotalBalance();
}
