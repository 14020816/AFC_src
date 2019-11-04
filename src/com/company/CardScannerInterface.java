package com.company;
import hust.soict.se.customexception.InvalidIDException;
import hust.soict.se.scanner.CardScanner;

public class  CardScannerInterface {

	public static String requestConvertBarCodeToCardID(String barCode) throws InvalidIDException {
		try {
			CardScanner cardScanner = CardScanner.getInstance();
			return cardScanner.process(barCode);
		}
		catch (Exception e){
			return  null;
		}
	}
}
