package com.company;

import hust.soict.se.customexception.InvalidIDException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ComandLineScreen {

	public static void displayMessage(String message) {
		System.out.println(message);
	}

	private static String inputBarCode() throws IOException {

		System.out.println("Input your barCode");
		String barCode = getLine();
		if(!barCode.isEmpty()) {
			return barCode;
		}else{
			displayMessage("Invalid Barcode");
			return  null;
		}
	}

	private static String inputEnterAndExitStation() throws IOException {
		System.out.println("Enter your enter and exit station");
		String stations = getLine();
		if(!stations.isEmpty() && stations.length() == 3) {
			return stations;
		}else{
			displayMessage("Invalid stations");
			return  null;
		}
	}
	private static   String getLine() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		return  line;
	}

	public static  void main(String[] args) throws IOException, InvalidIDException {
		init();
		while (true){
			String inputStation = new String();
			while (inputStation == null || inputStation.isEmpty()){
				inputStation = inputEnterAndExitStation();
			}

//			String barCode = new String();
//			while (barCode == null || barCode.isEmpty()){
//				barCode = inputBarCode();
//			}
			AFCController controller = new AFCController();
			int cert = selectCertificate();

			if(controller.ValidateCertificate(inputStation, cert, stationCatalog, certificateCatalog) == false){
				continue;
			}
		}
	}

	private static List<Station> stationCatalog;
	private static List<Certificate> certificateCatalog;

	public static void init(){
		// write your code here
		stationCatalog = new ArrayList<Station>();
		stationCatalog.add(new Station('a', "Saint-Lazare", 5));
		stationCatalog.add(new Station('b', "Madeleine", (float) 3.5));
		stationCatalog.add(new Station('c', "Pyramides", (float)2.8));
		stationCatalog.add(new Station('d', "Chatelet", (float) 4.5));
		stationCatalog.add(new Station('e', "Gare de Lyon",(float) 3.1));
		stationCatalog.add(new Station('f', "Bercy", (float) 3.1));
		stationCatalog.add(new Station('g', "Cour Saint-Emilion", (float)3.3));
		stationCatalog.add(new Station('h', "Bibliotheque Francois Mitterrand", (float)3.5));
		stationCatalog.add(new Station('i', "Olympiades",0));

		certificateCatalog = new ArrayList<Certificate>();
		certificateCatalog.add(new PrepaidCard("PC201910310001", (float)100));
		certificateCatalog.add(new OnewayTicket("OW201910310001", 'd','i', (float) 4.3));
		certificateCatalog.add(new TWTicket("TF201910310001",""));
		certificateCatalog.add(new TWTicket("TF201910310002","2019.10.30.14.35.00"));
	}

	public static int selectCertificate() throws IOException {
		try{
			System.out.println("Select you Certificate");
			for(int i=0; i < certificateCatalog.size(); i++){
				System.out.println("Certificate No." + Integer.toString(i));
				certificateCatalog.get(i).displayInformation();
			}
			String cert =  getLine();
			return Integer.parseInt(cert);
		}
		catch (Exception e){
			return  -1;
		}

	}

}
