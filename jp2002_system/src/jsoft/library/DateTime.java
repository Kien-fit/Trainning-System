package jsoft.library;

import java.text.*;
import java.util.*;

public class DateTime {

	public static String getFullDate(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static void main(String[] args) {
		System.out.print(DateTime.getFullDate("dd/MM/yyyy"));
	}

}
