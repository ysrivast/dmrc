package main;

import java.time.LocalDateTime;

import org.apache.log4j.BasicConfigurator;
import org.dmrc.exception.InsufficientBalanceException;
import org.dmrc.exception.MinimumBalanceException;
import org.dmrc.fare.FareStrategyFactory;
import org.dmrc.model.CardTxn;
import org.dmrc.model.SmartCard;
import org.dmrc.model.Stations;
import org.dmrc.model.Traveller;
import org.dmrc.service.DMRCService;
import org.dmrc.service.DMRCServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		DMRCService service = new DMRCServiceImpl();
		BasicConfigurator.configure();
		Traveller t = new Traveller();
		t.setId(1234);
		t.setName("Columbus");
		SmartCard card = new SmartCard();
		card.setId(9999999999999l);
		card.setBalance(71.87);
		card.setTraveller(t);
		System.out.println(card);
		System.out.println(FareStrategyFactory.getFareStrategy(LocalDateTime.of(2017, 1, 13, 00, 34)).getClass());
		CardTxn txn = new CardTxn();
		txn.setCard(card);
		txn.setTxnId("1256438TMP");
		txn.setDestination(Stations.A1);
		txn.setSource(Stations.A5);
		txn.setDistance(txn.getSource().distance(txn.getDestination()));
		txn.setInTime(LocalDateTime.now());
		txn.setOutTime(txn.getInTime().plusMinutes(45));
		txn.setFare(txn.getDistance()*FareStrategyFactory.getFareStrategy(txn.getInTime()).getFarePerStation());
		System.out.println(txn);
		
		try {
			service.swipeIn(card, Stations.A2,LocalDateTime.now());
		} catch (MinimumBalanceException e1) {
			System.err.println(e1.getMessage());
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			service.swipeOut(card, Stations.A9,LocalDateTime.now());
		} catch (InsufficientBalanceException e) {
		System.err.println(e.getMessage());
		}
		
	}
}
