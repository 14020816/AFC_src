package com.company;

import java.util.List;

public abstract class Ticket extends Certificate {
	public enum STATUS{
		NEW,
		INTRAVEL,
		USED
	}
	public STATUS status;

	@Override
	public void displayInformation() {
		super.displayInformation();
		System.out.println("*****Ticket information*****");
	}
}
