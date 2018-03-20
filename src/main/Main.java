package main;

import java.time.LocalDateTime;

import org.apache.log4j.BasicConfigurator;
import org.dmrc.fare.FareStrategyFactory;
import org.dmrc.model.CardTxn;
import org.dmrc.model.SmartCard;
import org.dmrc.model.Stations;
import org.dmrc.model.Traveller;

public class Main {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		Traveller t = new Traveller();
		t.setId(1234);
		t.setName("Columbus");
		//System.out.println();
		SmartCard card = new SmartCard();
		card.setId(9999999999999l);
		card.setBalance(145.87);
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
		
	}
}
