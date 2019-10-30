package com.company;

import java.util.List;

public class Certificate {

	public  enum  TYPE{
		CADR,
		ONEWAY,
		TWHOUR
	}


	public String ID;
	// 0 - Prepaid card
	// 1 - One way ticket
	// 2 - 24H ticket
	public TYPE type;

	public static List<Certificate> certificateCatalog;

	public static Certificate getCertificate(String ID) {
		for(int i = 0; i < certificateCatalog.size(); i++){
			if(certificateCatalog.get(i).ID == ID){
				return  certificateCatalog.get(i);
			}
		}
		return  null;
	}

	public  Certificate(String ID){
		this.ID = ID;
	}

	public  Certificate(){}

}
