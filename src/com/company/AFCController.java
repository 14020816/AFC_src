package com.company;
public class AFCController {

	private  CardScannerInterface  CardScannerInterface;

	private GateInterface gateInterface;

	public ComandLineScreen comandLineScreen;

	private TicketValidator ticketValidator;

	private Certificate certificate;

	private Station station;

	public  void start(){
		ComandLineScreen screen = new ComandLineScreen();
	}


	public void validateBarcode(char barCode) {


	}

	public boolean checkBalance( PrepaidCard card) {
		return false;
	}

	public void caculateFare() {

	}

}
