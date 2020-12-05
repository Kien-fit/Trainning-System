package jsoft.library;

import net.htmlparser.jericho.*;

public class Utilities_Support {

	public static String encode(String strUNI) {

		return CharacterReference.encode(strUNI);
	}
	
	public static String decode(String strHTML) {
		
		return CharacterReference.decode(strHTML);
	}

	public static String convert() {
		return null;
	}

}
