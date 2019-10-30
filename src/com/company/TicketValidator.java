package com.company;
public class TicketValidator {

	private Ticket ticket;

	public boolean validateExitOnewayTicket(Ticket tikcet, int exitStation) {

		return false;
	}

	public boolean validateEnterOnewayTicket(Ticket ticket, int enterStation) {
		if(ticket.status != Ticket.STATUS.NEW){
			return  false;
		}
		return  checkStartStaion(ticket, enterStation);
	}

	public boolean validateExit24HTicket(Ticket ticket, int exitStation) {
		return false;
	}

	public boolean validateEnter24HTicket(Ticket ticket, int entertStation) {
		return false;
	}

	private boolean checkStartStaion(Ticket ticket, int startStation) {
		if(startStation >= Station.stationCatalog.get(0).ID && startStation <= Station.stationCatalog.get(Station.stationCatalog.size()-1).ID){
			if(startStation >= ticket.startStation && startStation <= ticket.endStation){
				return  true;
			}
		}
		return  false;
	}

	private boolean validateTimeStart() {
		return false;
	}

	private boolean fareCalculate(Ticket ticket, int exitStation) {
		return false;
	}

	private void checkTicketUsed() {

	}

}
