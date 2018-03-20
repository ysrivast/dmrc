package org.dmrc.model;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;

public class SmartCard {
	private static final Logger logger= Logger.getLogger(SmartCard.class);
	private Traveller traveller;
	private long id;
	private double balance;
	public Traveller getTraveller() {
		return traveller;
	}
	public SmartCard() {
	//	logger.info(LocalDateTime.now()+" SmartCard obejct created");
	}
	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return this.getId()+" | "+this.getBalance()+" | "+this.getTraveller();
	}
}
