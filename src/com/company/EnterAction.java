package com.company;

import hust.soict.se.customexception.InvalidIDException;

import java.io.IOException;
import java.util.List;

public class EnterAction extends Action {
    @Override
    public boolean requestAction(AFCController controller, String barcode, List<Station> stationCatalog, List<Certificate> certificateCatalog,  List<TravelingHistory> travelingHistoryCatalog) throws IOException, InvalidIDException {
        return controller.validateEnter(this.station, barcode, stationCatalog, certificateCatalog, travelingHistoryCatalog);
    }
    public EnterAction(char station){
        this.station = station;
    }
}
