package net.frank.corejava1.ch14.synch2;


public class SynchBankTest {
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
	public static void main(String[] args) {
		Bank b = new Bank(NACCOUNTS,INITIAL_BALANCE);
		for (int i=0;i<NACCOUNTS;i++){
			TransferRunnable r = new TransferRunnable(b,i,INITIAL_BALANCE);
			new Thread(r).start();
		}
	}
}

class Bank{
	private final double[] accounts;
	public Bank(int n,double initialBalance){
		accounts = new double[n];
		for(int i=0;i<n;i++){
			accounts[i] = initialBalance;
		}
	}
	
	public synchronized void transfer(int from, int to,double amount)throws InterruptedException{
		while(accounts[from] < amount) {
			wait();
		}
		System.out.println(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d",amount,from,to);
		accounts[to] += amount;
		System.out.printf(" Total balance : %10.2f%n", getTotalBalance());
		notifyAll();
	}

	public synchronized Object getTotalBalance() {
		double sum = 0;
		for(double a : accounts){
			sum += a;
		}
		return sum;
		
	}
	
	public int size(){
		return accounts.length;
	}
}

class TransferRunnable implements Runnable{
	
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY =10;
	
	public TransferRunnable(Bank b,int from ,double max){
		this.bank = b;
		this.fromAccount = from;
		this.maxAmount = max;
	}
	
	@Override
	public void run() {
		try{
			while(true){
				int toAccount = (int) (bank.size()* Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount , amount);
				Thread.sleep((int)(DELAY * Math.random()));
			}
		}catch(InterruptedException e){
			
		}
	}
	
}

/***
 * Class java.lang.Object
 * void notifyAll()
 * 解除那些在该对象上调用wait方法的线程的阻塞状态。该方法只能在同步方法或同步块内调用。如果当前线程不是对象锁的持有者，该方法抛出一个IllegalMonitorStateException异常。
 * 
 * void notify()
 * 随机选择一个在该对象上调用wait方法的线程，解除其阻塞状态。
 * 
 * void wait()
 * 导致线程进入等待状态直到它被通知。
 * 
 * void wait(long millis)
 * void wait(long millis, int nanos)
 * 导致线程进入等待状态直到它被通知或者经过指定的时间。
 */
