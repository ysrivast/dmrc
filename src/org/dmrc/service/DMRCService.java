package org.dmrc.service;

import java.time.LocalDateTime;

import org.dmrc.exception.InsufficientBalanceException;
import org.dmrc.exception.MinimumBalanceException;
import org.dmrc.model.SmartCard;
import org.dmrc.model.Stations;

public interface DMRCService {
	

	void swipeIn(SmartCard card, Stations source,LocalDateTime dateTime) throws  MinimumBalanceException;
	void swipeOut(SmartCard card, Stations source,LocalDateTime dateTime) throws InsufficientBalanceException;
}
