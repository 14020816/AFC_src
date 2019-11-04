package com.company;

import hust.soict.se.customexception.InvalidIDException;

import java.io.IOException;
import java.util.List;

public class ExitAction extends Action {
    @Override
    public boolean requestAction(AFCController controller, String barcode, List<Station> stationCatalog, List<Certificate> certificateCatalog,  List<TravelingHistory> travelingHistoryCatalog) throws IOException, InvalidIDException {
        return controller.validateExit(this.station, barcode, stationCatalog, certificateCatalog, travelingHistoryCatalog);
    }
    public ExitAction(char station){
        this.station = station;
    }
}
