package com.company;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public class Station {

	public String name;

	public  float  distance;

	public char ID;

	public static Station getStationByID(char ID, List<Station> stationCatalog) {
		for(int i = 0; i < stationCatalog.size(); i++){
			if(stationCatalog.get(i).ID == ID){
				return stationCatalog.get(i);
			}
		}
		return  null;
	}
	public  Station(char id, String name, float  distance){
		this.ID = id;
		this.name = name;
		this.distance = distance;
	}
	public  Station(){}

	public  void displayInformation(){
		System.out.println("*****Station information********");
		System.out.println("StationID: " + this.ID);
		System.out.println("StationName: " + this.name);
	}

	public static float getDistance(char enterStaion, char exitStation, List<Station> stationCatalog){
		char enter = enterStaion;
		char exit = exitStation;
		if((int)enterStaion > (int)exitStation){
			enter = exitStation;
			exit = enterStaion;
		}
		if(getStationByID(enterStaion, stationCatalog) == null || getStationByID(exitStation, stationCatalog) == null || enterStaion == exitStation){
			return  0;
		}else{
			float distance = 0;
			for(int i =0; i < (int)exit - (int)enter; i++){
				distance += getStationByID((char)(int)(enter + i), stationCatalog).distance;
			}
			return  distance;
		}
	}
	public  static Station getLastStationByTicketID(String certificateID, List<TravelingHistory> travelingHistoryList, List<Station> stationList){
	    for(int i = travelingHistoryList.size() -1; i >= 0; i-- ){
	        if(travelingHistoryList.get(i).getCertificateID().equals(certificateID)){
                return  getStationByID(travelingHistoryList.get(i).getStation(), stationList);
            }
        }
	    return null;
    }
}
