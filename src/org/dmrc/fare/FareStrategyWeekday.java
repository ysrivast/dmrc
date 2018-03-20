package org.dmrc.fare;

public class FareStrategyWeekday implements FareStrategy {
	
	public FareStrategyWeekday() {
	}
	@Override
	public String getName() {
		return "FareStrategyWeekday";
	}

	@Override
	public double getFarePerStation() {
		return 7;
	}

}
