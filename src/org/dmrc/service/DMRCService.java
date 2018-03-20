package org.dmrc.service;

import org.dmrc.model.CardTxn;
import org.dmrc.model.SmartCard;

public interface DMRCService {
	
	private SmartCard card;
	private CardTxn txn;
	void swipIn();
}
