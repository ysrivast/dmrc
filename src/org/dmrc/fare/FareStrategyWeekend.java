package org.dmrc.fare;

public class FareStrategyWeekend implements FareStrategy {
	
	public FareStrategyWeekend() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "FareStrategyWeekend";
	}

	@Override
	public double getFarePerStation() {
		// TODO Auto-generated method stub
		return 5.5;
	}

}
