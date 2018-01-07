package net.frank.corejava1.ch14.synch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
	private Lock bankLock;
	private Condition sufficientFunds;
	public Bank(int n,double initialBalance){
		accounts = new double[n];
		for(int i=0;i<n;i++){
			accounts[i] = initialBalance;
		}
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}
	
	public void transfer(int from, int to,double amount)throws InterruptedException{
		bankLock.lock();
		try {
			while(accounts[from] < amount) {
				sufficientFunds.await();
			}
			System.out.println(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d",amount,from,to);
			accounts[to] += amount;
			System.out.printf(" Total balance : %10.2f%n", getTotalBalance());
			sufficientFunds.signalAll();
		}finally {
			bankLock.unlock();
		}
		
	}

	public Object getTotalBalance() {
		bankLock.lock();
		try {
			double sum = 0;
			for(double a : accounts){
				sum += a;
			}
			return sum;
		}finally {
			bankLock.unlock();
		}
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
 * Class java.util.concurrent.locks.Lock
 * void lock()
 * 获取这个锁，如果锁同时被另一个线程拥有则发生阻塞
 * 
 * void unlock()
 * 释放这个锁
 * 
 * Condition newCondition()
 * 返回一个与该锁相关的条件对象
 * 
 * Class java.util.concurrent.locks.ReentrantLock
 * ReentrantLock()
 * 构建一具可以用来保护临界区的可重入锁
 * 
 * ReentrantLock(boolean fair)
 * 构建一个带有公平策略的锁。一个公平锁偏爱等待时间最长的线程。但是，这一公平的保证将大大降低性能。所以，默认情况下，锁没有被强制为公平的
 * 
 * Class java.util.concurrent.locks.Condition
 * void await()
 * 将该线程放到条件的等待集中
 * 
 * void signalAll()
 * 解除该条件的等待集中的所有线程的阻塞状态
 * 
 * void signal()
 * 从该条件的等待集中随机地选择一个线程，解除其阻塞状态
 */
