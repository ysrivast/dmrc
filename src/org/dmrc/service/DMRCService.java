package org.dmrc.service;

import java.time.LocalDateTime;

import org.dmrc.model.SmartCard;
import org.dmrc.model.Stations;

public interface DMRCService {
	

	void swipIn(SmartCard card, Stations source,LocalDateTime dateTime);
	void swipeOut(SmartCard card, Stations source,LocalDateTime dateTime);
}
