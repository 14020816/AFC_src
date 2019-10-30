package com.company;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public class Station {
	public static List<Station> stationCatalog;

	public String name;

	public int ID;

	public Station getStationByID(int ID) {
		for(int i = 0; i < stationCatalog.size(); i++){
			if(stationCatalog.get(i).ID == ID){
				return stationCatalog.get(i);
			}
		}
		return  null;
	}
	public  Station(int id, String name){
		this.ID = id;
		this.name = name;
	}
	public  Station(){}



}
