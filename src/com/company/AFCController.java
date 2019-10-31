package com.company;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AFCController {

	public static void main(String[] args) throws IOException {
		// write your code here
//		AFCController controller = new AFCController();
		ComandLineScreen screen = new ComandLineScreen();
		Station station = new Station();
		//TravelingHistory travelingHistory = new TravelingHistory();
		//dummy
		List<Station> stationCatalog = new ArrayList<Station>();
//		Station.stationCatalog = new ArrayList<Station>();
        /*for(int i = 0; i < 10; i++){
            Station.stationCatalog.add(new Station(i,"Station" + Integer.toString(i)));
        }*/
		stationCatalog.add(new Station('a', "Saint-Lazare", 5));
		stationCatalog.add(new Station('b', "Madeleine", (float) 3.5));
		stationCatalog.add(new Station('c', "Pyramides", (float)2.8));
		stationCatalog.add(new Station('d', "Chatelet", (float) 4.5));
		stationCatalog.add(new Station('e', "Gare de Lyon",(float) 3.1));
		stationCatalog.add(new Station('f', "Bercy", (float) 3.1));
		stationCatalog.add(new Station('g', "Cour Saint-Emilion", (float)3.3));
		stationCatalog.add(new Station('h', "Bibliotheque Francois Mitterrand", (float)3.5));
		stationCatalog.add(new Station('i', "Olympiades",0));

		//
		List<Certificate> certificateCatalog = new ArrayList<Certificate>();
		certificateCatalog = new ArrayList<Certificate>();
		certificateCatalog.add(new PrepaidCard("PC201910310001", (float)100));
		certificateCatalog.add(new OnewayTicket("OW201910310001", 'd','i'));
		certificateCatalog.add(new TWTicket("TF201910310001",""));
		certificateCatalog.add(new TWTicket("TF201910310002","2019.10.20.14.35.00"));
		//TravelingHistory.travelCatalog = new ArrayList<TravelingHistory>();

		while (true){
			try {
				String inputStation = new String();
				while (inputStation == null || inputStation.isEmpty()){
					inputStation = screen.inputEnterAndExitStation();
				}
				Station enterStaion = station.getStationByID(inputStation.charAt(0), stationCatalog);
				Station exitStaion = station.getStationByID(inputStation.charAt(2), stationCatalog);
				String barCode = new String();
				while (barCode.isEmpty()){
					barCode = screen.inputBarCode();
				}
				String certificateid = CardScannerInterface.requestConvertBarCodeToCardID(barCode);
				enterStaion.displayInformation();
				Certificate certificate = Certificate.getCertificate(certificateid, certificateCatalog);
				if(certificate ==  null){
					screen.displayErrorMessage("Invalid barcode");
					continue;
				}
				// Enter staion
				if(certificate.type == CertificateType.TYPE.PREPAIDCARD){
					if(((PrepaidCard)certificate).balance <= Card.BASE_FARE) {
						screen.displayErrorMessage("not enough base money");
						continue;
					}
				}else{
					Boolean result =  ((Ticket)certificate).validateEnterTicket(enterStaion.ID, stationCatalog);
					if(!result){
						screen.displayErrorMessage("Invalid Ticket");
						continue;
					}
				}
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
				TravelingHistory.recordEnterTraveling(timeStamp, enterStaion.ID, certificate.ID);
				GateInterface.requestToOpenGate();
				certificate.displayInformation();
				//Exit staion
				if(certificate.type == CertificateType.TYPE.PREPAIDCARD){
					float fare = FareCaculator.FareCaculate(enterStaion.ID, exitStaion.ID, stationCatalog);
					if(fare < ((PrepaidCard)certificate).balance){
						((PrepaidCard)certificate).balance = ((PrepaidCard)certificate).balance - fare;
						GateInterface.requestToOpenGate();
						certificate.displayInformation();
					}
				}

				TravelingHistory.recordExitTraveling(timeStamp, enterStaion.ID, certificate.ID);


			}catch (Exception e){
				throw  e;
			}
		}

	}



}
