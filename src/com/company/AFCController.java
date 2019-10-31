package com.company;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AFCController {

	public boolean ValidateCertificate(String inputStation, int certificateNumber, List<Station> stationCatalog, List<Certificate> certificateCatalog) throws IOException {
        try {
            Station enterStaion = Station.getStationByID(inputStation.charAt(0), stationCatalog);

            if(enterStaion == null){
                ComandLineScreen.displayMessage("Invalid enter station");
                return  false;
            }
            ComandLineScreen.displayMessage("*******ENTER STATION**********");
            enterStaion.displayInformation();
            if(certificateNumber < 0 || certificateNumber >= certificateCatalog.size()){
                ComandLineScreen.displayMessage("Invalid certificateNumber");
                return  false;
            }
            Certificate certificate = certificateCatalog.get(certificateNumber);
            if(certificate ==  null){
                ComandLineScreen.displayMessage("Invalid certificateNumber");
                return  false;
            }
            // Enter staion
            if(certificate.validateEnter(enterStaion.ID) == false){
                certificate.dispayError();
                return  false;
            };
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            TravelingHistory.recordEnterTraveling(timeStamp, enterStaion.ID, certificate.ID);
            GateInterface.requestToOpenGate();
            certificate.displayInformation();
            //Exit station
            Station exitStaion = Station.getStationByID(inputStation.charAt(2), stationCatalog);
            if(exitStaion == null){
                ComandLineScreen.displayMessage("Invalid exit station");
                return  false;
            }
            exitStaion.displayInformation();
            ComandLineScreen.displayMessage("*******EXIT STATION**********");
            timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            certificate.validateExit(Station.getDistance(enterStaion.ID, exitStaion.ID, stationCatalog));
            certificate.displayInformation();
            TravelingHistory.recordExitTraveling(timeStamp, enterStaion.ID, certificate.ID);
            GateInterface.requestToOpenGate();
            return  false;
        }catch (Exception e){
            throw  e;
        }
	}

}
