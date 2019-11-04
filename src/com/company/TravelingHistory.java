package com.company;
import org.omg.CORBA.TRANSACTION_MODE;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.List;

public class TravelingHistory {
	public  static  int IDCOUNT;
	public enum  ACTION{
		ENTER,
		EXIT
	}
	private int ID;

	public  ACTION action;
	private String certificateID;

	private String time;

	private char station;


//	public static List<TravelingHistory> travelCatalog;

	public static void recordEnterTraveling(String time, char station, String id, List<TravelingHistory> travelCatalog) {
		if(travelCatalog == null){
			travelCatalog = new ArrayList<TravelingHistory>();
		}
		travelCatalog.add(new TravelingHistory(ACTION.ENTER, time, station,id));
	}

	public static void recordExitTraveling(String endTime, char endStation, String id, List<TravelingHistory> travelCatalog) {
		if(travelCatalog == null){
			travelCatalog = new ArrayList<TravelingHistory>();
		}
		travelCatalog.add(new TravelingHistory(ACTION.EXIT, endTime, endStation,id));
	}




	public TravelingHistory(ACTION action, String time, char station, String certificateID){
		this.action = action;
		this.time = time;
		this.station = station;
		this.certificateID = certificateID;
		this.ID = ++TravelingHistory.IDCOUNT;
	}
	public String getCertificateID(){
		return  this.certificateID;
	}

	public char getStation(){
		return this.station;
	}

}
