package com.test.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	       Date dateobj = new Date();
	       System.out.println(df.format(dateobj));
	}

}
