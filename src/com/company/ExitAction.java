package com.company;

import hust.soict.se.customexception.InvalidIDException;

import java.io.IOException;
import java.util.List;

public class ExitAction extends Action {
    @Override
    public void requestAction(AFCController controller, int certificateNumber, List<Station> stationCatalog, List<Certificate> certificateCatalog,  List<TravelingHistory> travelingHistoryCatalog) throws IOException, InvalidIDException {
        controller.validateExit(this.station, certificateNumber, stationCatalog, certificateCatalog, travelingHistoryCatalog);
    }
    public ExitAction(char station){
        this.station = station;
    }
}
