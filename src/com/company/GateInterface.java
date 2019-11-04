
package com.company;
import hust.soict.se.gate.Gate;

public class  GateInterface {

	public static void requestToOpenGate() {
		System.out.println("Opening gate…");
		Gate gate = Gate.getInstance();
		gate.open();
	}

}
