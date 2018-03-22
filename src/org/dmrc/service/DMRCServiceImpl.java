package org.dmrc.service;

import java.time.LocalDateTime;

import org.dmrc.model.CardTxn;
import org.dmrc.model.SmartCard;
import org.dmrc.model.Stations;

public class DMRCServiceImpl implements DMRCService{
	private SmartCard card;
	private CardTxn txn;
	@Override
	public void swipIn(SmartCard card, Stations source,LocalDateTime dateTime) {
		System.out.println("SwipeIn"+ source+ card.getId() );
	}
	@Override
	public void swipeOut(SmartCard card, Stations source,LocalDateTime dateTime) {
		System.out.println("SwipeOut"+ source+ card.getId() );
		
	}
}
