package com.company;
public abstract class Ticket extends Certificate {
	public enum STATUS{
		NEW,
		INTRAVEL,
		USED
	}

	public STATUS status;

	public  Ticket(){}

	public Ticket(String ID){
		super(ID);
	}

	@Override
	public void displayInformation() {
		super.displayInformation();
		System.out.println("*****Ticket information*****");
	}

	public abstract boolean validateEnterTicket(char enterStation);
	public abstract boolean validateExitTicket(char exitStation);
}
