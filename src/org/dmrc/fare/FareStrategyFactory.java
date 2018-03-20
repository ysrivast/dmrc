package org.dmrc.fare;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class FareStrategyFactory {
	FareStrategy strategy;

	public static FareStrategy getFareStrategy(LocalDateTime time) {
		if (time.getDayOfWeek()==DayOfWeek.SATURDAY | time.getDayOfWeek()==DayOfWeek.SUNDAY)
			return new FareStrategyWeekend();
		return new FareStrategyWeekday();

	}
}
