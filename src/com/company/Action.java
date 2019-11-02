package com.company;

import hust.soict.se.customexception.InvalidIDException;

import java.io.IOException;
import java.util.List;



public abstract class Action {
    protected char station;
    public abstract   void  requestAction(AFCController controller, int certificateNumber, List<Station> stationCatalog, List<Certificate> certificateCatalog,  List<TravelingHistory> travelingHistoryCatalog) throws IOException, InvalidIDException;
}
