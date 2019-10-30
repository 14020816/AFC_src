package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComandLineScreen {

	public void displayErrorMessage(String message) {
		System.out.println(message);
	}

	public String inputBarCode() throws IOException {

		System.out.println("Input your barCode");
		String barCode = this.getLine();
		if(!barCode.isEmpty()) {
			return barCode;
		}else{
			displayErrorMessage("Invalid Barcode");
			return  null;
		}
	}

	public String inputEnterAndExitStation() throws IOException {
		System.out.println("Enter your enter and exit station");
		String stations = this.getLine();
		if(!stations.isEmpty() && stations.length() == 3) {
			return stations;
		}else{
			displayErrorMessage("Invalid stations");
			return  null;
		}
	}
	private  String getLine() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		return  line;
	}
}
