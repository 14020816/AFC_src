package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        AFCController controller = new AFCController();
        ComandLineScreen screen = new ComandLineScreen();
        Station station = new Station();
        TravelingHistory travelingHistory = new TravelingHistory();
        //dummy
        Station.stationCatalog = new ArrayList<Station>();
        for(int i = 0; i < 10; i++){
            Station.stationCatalog.add(new Station(i,"Station" + Integer.toString(i)));
        }
        Certificate.certificateCatalog = new ArrayList<Certificate>();
        Certificate.certificateCatalog.add(new Card("aaaaaa", 1));
        Certificate.certificateCatalog.add(new Ticket("bbbbbb", 1,4));
        Certificate.certificateCatalog.add(new Ticket("cccccc","20190920"));

        TravelingHistory.travelCatalog = new ArrayList<TravelingHistory>();

        while (true){
            try {
                String inputStation = new String();
                while (inputStation.isEmpty()){
                    inputStation = screen.inputEnterAndExitStation();
                }
                Station enterStaion = station.getStationByID(Integer.parseInt(Character.toString(inputStation.charAt(0))));
                Station exitStaion = station.getStationByID(Integer.parseInt(Character.toString(inputStation.charAt(2))));
                String barCode = new String();
                while (barCode.isEmpty()){
                    barCode = screen.inputBarCode();
                }
                String certificateid = "aaaaaa";
                Certificate certificate = Certificate.getCertificate(certificateid);
                if(certificate.type == Certificate.TYPE.CADR){
                   if(((Card)certificate).balance <= Card.BASE_FARE) {
                       screen.displayErrorMessage("not enough base money");
                       continue;
                   }

                }else{

                }
            }catch (Exception e){
                throw  e;
            }
        }

    }
}
