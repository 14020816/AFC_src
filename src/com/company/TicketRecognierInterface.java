package  com.company;
import hust.soict.se.customexception.InvalidIDException;
import hust.soict.se.recognizer.TicketRecognizer;

public class TicketRecognierInterface {

	public static String requestConvertBarCodeToTicketID( String pseudoBarCode) throws InvalidIDException { ;
		TicketRecognizer ticketRecognizer = TicketRecognizer.getInstance();
		return ticketRecognizer.process(pseudoBarCode);
	}

}
