package jsoft.library;

import javax.servlet.*;

public class Utilities {
	
	public static byte getByteParam(ServletRequest request, String name) {
		Byte value = -1;
		
		String strValue = request.getParameter(name);
		if(strValue!=null && !strValue.equalsIgnoreCase("")) {
			value = Byte.parseByte(strValue);
		}
		
		return value;
	}
	
	public static short getShortParam(ServletRequest request, String name) {
		short value = -1;
		
		String strValue = request.getParameter(name);
		if(strValue!=null && !strValue.equalsIgnoreCase("")) {
			value = Short.parseShort(strValue);
		}
		
		return value;
	}
	
	public static int getIntParam(ServletRequest request, String name) {
		int value = -1;
		
		String strValue = request.getParameter(name);
		if(strValue!=null && !strValue.equalsIgnoreCase("")) {
			value = Integer.parseInt(strValue);
		}
		
		return value;
	}

}
