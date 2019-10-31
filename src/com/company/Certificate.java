package com.company;

import java.util.List;


public class Certificate {



	public String ID;

	public CertificateType.TYPE type;

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



}
