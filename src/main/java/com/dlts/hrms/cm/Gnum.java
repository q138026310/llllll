package com.dlts.hrms.cm;

public class Gnum {

	public int value;
	public String text;

	public static Gnum newGnum(int value, String text) {
		Gnum n = new Gnum();
		n.value = value;
		n.text = text;
		return n;
	}

}
