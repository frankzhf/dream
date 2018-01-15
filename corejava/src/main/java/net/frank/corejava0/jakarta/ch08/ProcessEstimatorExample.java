package net.frank.corejava0.jakarta.ch08;

import org.apache.commons.lang.math.RandomUtils;

public class ProcessEstimatorExample {
	
	private ProcessEstimator estimate;
	
	public void begin() {
		estimate = new ProcessEstimator(10000,100);
		estimate.start();
		for(int i=0;i<10000;i++) {
			printStatus(i);
			performLengthyProcess();
			estimate.unitCompleted();
		}
		estimate.stop();
		
		System.out.println("Completed " + estimate.getUnits() + " in " + 
				Math.round(estimate.getTimeSpent()/1000) + "seconds." );
		
	}
	
	private void performLengthyProcess() {
		try {
			Thread.sleep(RandomUtils.nextInt(10));
		}catch(InterruptedException e){
			
		}
	}

	private void printStatus(int i) {
		if(i%1000 == 0) {
			System.out.println("Completed: "+ estimate.getCompleted() + " of " +estimate.getUnits());
			System.out.println("\tTime Spent "+ 
					Math.round(estimate.getTimeSpent()/1000) + 
					" sec, Time Remaining:  " + 
					Math.round(estimate.projectedTimeRemaining())/1000 + " sec");
			
		}
	}
	
	
	public static void main(String[] args) {
		ProcessEstimatorExample example = new ProcessEstimatorExample();
		example.begin();
	}

}	
