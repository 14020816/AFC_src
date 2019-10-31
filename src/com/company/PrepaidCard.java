package com.company;
public class  PrepaidCard extends Card {

	public float balance;
	public  int lastStaion;

	public  PrepaidCard(String ID, float balance){
		super(ID);
		this.balance = balance;
		this.lastStaion = -1;
	}
	@Override
	public void displayInformation() {
		super.displayInformation();
		System.out.println("*****Prepaid card information*****");
		System.out.println("Type:  Prepaid-card       ID: " + this.ID);
		System.out.println("Balance: " + this.balance);
	}

	@Override
	public boolean validateEnter(char enterStaion) {
		if(this.balance >= FareCaculator.BASE_FARE){
			return  true;
		}
		return  false;
	}

	@Override
	public boolean validateExit(float distance) {
		float fare = FareCaculator.fareCaculate(distance);
		if(this.balance > fare){
			this.balance = this.balance - fare;
			return true;
		}
		return  false;
	}

	@Override
	public void dispayError() {

	}

}
