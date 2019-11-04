package com.company;

import hust.soict.se.customexception.InvalidIDException;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AFCController {


	public boolean validateEnter(char inputStation, String barCode, List<Station> stationCatalog, List<Certificate> certificateCatalog, List<TravelingHistory> travelingHistoryCatalog) throws InvalidIDException {
        Station enterStation = Station.getStationByID(inputStation, stationCatalog);
        if(enterStation == null){
            ComandLineScreen.displayMessage("Invalid enter station");
            return  false;
        }
        ComandLineScreen.displayMessage("*******ENTER STATION**********");
        Certificate certificate = Certificate.getCertificateByBarcode(barCode, certificateCatalog);
        if(certificate ==  null){
            ComandLineScreen.displayMessage("Invalid certificateNumber");
            return  false;
        }
        if(certificate.validateEnter(enterStation.ID) == false){
            certificate.dispayError();
            return  false;
        };
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        enterStation.displayInformation();
        certificate.displayInformation();
        TravelingHistory.recordEnterTraveling(timeStamp, enterStation.ID, certificate.ID, travelingHistoryCatalog);
        GateInterface.requestToOpenGate();
        return  false;
    }

    public boolean validateExit(char inputStation, String barCode, List<Station> stationCatalog, List<Certificate> certificateCatalog, List<TravelingHistory> travelingHistoryCatalog) throws  InvalidIDException{
        Station exitStaion = Station.getStationByID(inputStation, stationCatalog);
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        if(exitStaion == null){
            ComandLineScreen.displayMessage("Invalid exit station");
            return  false;
        }
        Certificate certificate = Certificate.getCertificateByBarcode(barCode, certificateCatalog);
        if(certificate ==  null){
            ComandLineScreen.displayMessage("Invalid certificateNumber");
            return  false;
        }
        ComandLineScreen.displayMessage("*******EXIT STATION**********");
        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Station enterStaion = Station.getLastStationByTicketID(certificate.ID, travelingHistoryCatalog, stationCatalog);
        if(certificate.validateExit(Station.getDistance(enterStaion.ID, exitStaion.ID, stationCatalog)) == false){
            return  false;
        }
        exitStaion.displayInformation();
        certificate.displayInformation();
        TravelingHistory.recordExitTraveling(timeStamp, enterStaion.ID, certificate.ID, travelingHistoryCatalog);
        GateInterface.requestToOpenGate();
        return  false;
    }

}
