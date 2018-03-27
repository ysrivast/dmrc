package org.dmrc.service;

import java.time.LocalDateTime;

import org.dmrc.exception.InsufficientBalanceException;
import org.dmrc.exception.MinimumBalanceException;
import org.dmrc.model.CardTxn;
import org.dmrc.model.SmartCard;
import org.dmrc.model.Stations;

public class DMRCServiceImpl implements DMRCService{
	private SmartCard card;
	private CardTxn txn= new CardTxn();
	
	@Override
	public void swipeIn(SmartCard card, Stations source,LocalDateTime dateTime) throws  MinimumBalanceException {
		if(card.getBalance()<5.5) throw new MinimumBalanceException("Minimum balance 5.5$");
		System.out.println("SwipeIn"+ source+ card.getId() );
	}
	@Override
	public void swipeOut(SmartCard card, Stations source,LocalDateTime dateTime) throws InsufficientBalanceException {
		txn.setFare(20.5);
		if(txn.getFare()>card.getBalance()) throw new InsufficientBalanceException("InsufficientBalance");
		System.out.println("SwipeOut"+ source+ card.getId() );
		
	}
}
