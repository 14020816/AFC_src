package com.company;
public class  PrepaidCard extends Card {

	public float balance;
	public  int lastStaion;

	public  PrepaidCard(String ID, float balance){
		super(ID);
		this.type = CertificateType.TYPE.PREPAIDCARD;
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
	public boolean validateEnter(int enterStation) {
		return false;
	}

	@Override
	public boolean validateExit(int enterStation) {
		return false;
	}


}
