package org.dmrc.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class CardTxn {
	private Stations source;
	private Stations destination;
	private String txnId;
	private int distance;
	private double fare;
	private LocalDateTime inTime;
	private LocalDateTime outTime;
	private SmartCard card;
	
	public CardTxn() {
		txnId=UUID.randomUUID().toString();
	}

	public Stations getSource() {
		return source;
	}

	public void setSource(Stations source) {
		this.source = source;
	}

	public Stations getDestination() {
		return destination;
	}

	public void setDestination(Stations a1) {
		this.destination = a1;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public LocalDateTime getInTime() {
		return inTime;
	}

	public void setInTime(LocalDateTime inTime) {
		this.inTime = inTime;
	}

	public LocalDateTime getOutTime() {
		return outTime;
	}

	public void setOutTime(LocalDateTime outTime) {
		this.outTime = outTime;
	}

	public SmartCard getCard() {
		return card;
	}

	public void setCard(SmartCard card) {
		this.card = card;
	}

	public String getTxnId() {
		return txnId;
	}

	@Override
	public String toString() {
		return this.getCard() + " | " + this.getTxnId() + " | " + this.getSource() + " | " + this.getDestination()
				+ " | " + this.getDistance() + " | " + this.getInTime() + " | " + this.getOutTime() + " | "
				+ this.getFare();
	}
}
