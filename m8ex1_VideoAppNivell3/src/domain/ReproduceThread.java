package domain;

import java.util.concurrent.atomic.AtomicBoolean;

public class ReproduceThread implements Runnable {
	private Thread worker;
	private AtomicBoolean running = new AtomicBoolean(false);
	
	private volatile int returnValue;
	int limit = 0;
	int timeCounter = 0;
	
	public ReproduceThread() {}
	
	public void start(int start, int limit) {
		if(start > 0) {
			this.timeCounter = start;
		} else {
			this.timeCounter = 0;
		}
		this.limit = limit;
		this.returnValue = start;
		this.worker = new Thread(this);
		this.worker.start();
	}
	
	public void stop() {
		running.set(false);
	}
	
	public void run() {
		running.set(true);
		
		while(running.get()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
				returnValue = this.limit+1;
			}
			
			this.timeCounter++;
			returnValue = timeCounter;
			
			if(this.timeCounter > this.limit - 1) {
				running.set(false);
			}
		}
	}
	
	public int getValue() {
		return returnValue;
	}
}