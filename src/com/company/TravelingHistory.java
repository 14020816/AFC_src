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

	private int station;


	public static List<TravelingHistory> travelCatalog;

	public static void recordEnterTraveling(String time, int station, String id) {
		if(travelCatalog == null){
			travelCatalog = new ArrayList<TravelingHistory>();
		}
		travelCatalog.add(new TravelingHistory(ACTION.ENTER, time, station,id));
	}

	public static void recordExitTraveling(String endTime, int endStation, String id) {

	}

	public int calculateDistance() {
		return 0;
	}

	public void saveTravelingInformation() {

	}

	public int caculateDistance() {
		return 0;
	}

	public TravelingHistory(ACTION action, String time, int station, String certificateID){
		this.action = action;
		this.time = time;
		this.station = station;
		this.certificateID = certificateID;
		this.ID = ++TravelingHistory.IDCOUNT;
	}

}
