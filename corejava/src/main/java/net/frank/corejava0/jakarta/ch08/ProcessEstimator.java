package net.frank.corejava0.jakarta.ch08;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.math3.stat.regression.SimpleRegression;

public class ProcessEstimator {
	private SimpleRegression regression = new SimpleRegression();
	private StopWatch stopWatch = new StopWatch();
	
	private int units = 0;
	
	private int completed = 0;
	
	private int sampleRate =1;
	
	public ProcessEstimator(int units, int sampleRate) {
		this.units = units;
		this.sampleRate = sampleRate;
	}
	
	public void start() {
		stopWatch.start();
	}
	
	public void stop(){
		stopWatch.stop();
	}
	
	public void unitCompleted() {
		completed ++;
		if(completed % sampleRate == 0) {
			//long now = System.currentTimeMillis();
			regression.addData(units - completed, stopWatch.getTime());
		}
	}
	public long projectedFinish() {
		return (long) regression.getIntercept();
	}
	
	public long getTimeSpent() {
		return stopWatch.getTime();
	}
	
	public long projectedTimeRemaining() {
		long timeRemaining = projectedFinish() - getTimeSpent();
		return timeRemaining;
	}
	
	public int getUnits() {
		return this.units;
	}
	public int getCompleted() {
		return completed;
	}	
}
