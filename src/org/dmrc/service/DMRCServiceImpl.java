package org.dmrc.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.dmrc.exception.InsufficientBalanceException;
import org.dmrc.exception.MetroException;
import org.dmrc.exception.MinimumBalanceException;
import org.dmrc.fare.FareStrategyFactory;
import org.dmrc.model.CardTxn;
import org.dmrc.model.SmartCard;
import org.dmrc.model.Stations;

public class DMRCServiceImpl implements DMRCService{
	Map<String, CardTxn> map = new HashMap<>();
	@Override
	public void swipeIn(SmartCard card, Stations source,LocalDateTime dateTime) throws  MinimumBalanceException {
		if(card.getBalance()<5.5) throw new MinimumBalanceException("Minimum balance 5.5$ for transaction " );
		CardTxn txn= new CardTxn();
		txn.setCard(card);
		txn.setInTime(dateTime);
		txn.setSource(source);
		map.put(card.getId(), txn);
		System.out.println(txn );
	}
	@Override
	public void swipeOut(SmartCard card, Stations destination,LocalDateTime dateTime) throws InsufficientBalanceException, MetroException {
		if(!map.containsKey(card.getId())) throw new MetroException("Invalid User");
		CardTxn txn= map.get(card.getId());
		txn.setCard(card);
		txn.setDestination(destination);
		txn.setOutTime(dateTime);
		txn.setDistance(txn.getSource().distance(destination));
		txn.setFare(txn.getDistance() * FareStrategyFactory.getFareStrategy(txn.getInTime()).getFarePerStation());
		if(txn.getFare()>card.getBalance()) throw new InsufficientBalanceException("InsufficientBalance");
		System.out.println(txn);
		
	
		
	}
}
