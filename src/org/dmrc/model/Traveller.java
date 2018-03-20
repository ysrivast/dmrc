package org.dmrc.model;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;

public class Traveller {
	private static final Logger logger= Logger.getLogger(Traveller.class);
	private long id;
	private String name;
	public Traveller() {
		super();
	//	logger.info(LocalDateTime.now()+" Traveller object created");
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.getId() +" | "+this.getName();
	}
}
