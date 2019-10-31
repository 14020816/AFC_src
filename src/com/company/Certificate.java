package com.company;

import java.util.List;


public abstract class Certificate {

	public String ID;
	protected   String error;

	public static Certificate getCertificate(String ID, List<Certificate> certificateCatalog) {
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

	public  void displayInformation(){}
	public  abstract boolean validateEnter(char enterStaion);
	public  abstract boolean validateExit(float distance);
	public  void dispayError(){
		if(error != null){
			System.out.println(error);
		}
	}

}
