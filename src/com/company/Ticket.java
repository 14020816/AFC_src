package com.company;
public class Ticket extends Certificate {
	public enum STATUS{
		NEW,
		INTRAVEL,
		USED
	}

	public String startTime;

	public STATUS status;

	public int startStation;

	public int endStation;

	public Ticket(String ID,String startTime){
		super(ID);
		this.type = TYPE.TWHOUR;
		this.status = STATUS.NEW;
		this.startTime = startTime;
	}

	public Ticket(String ID, int startStation, int endStation ){
		super(ID);
		this.type = TYPE.ONEWAY;
		this.startStation = startStation;
		this.endStation = endStation;
	}
}
