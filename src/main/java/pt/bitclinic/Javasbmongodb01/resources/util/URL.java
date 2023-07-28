package pt.bitclinic.Javasbmongodb01.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.format.DateTimeParseException;

public class URL {
	public static String decodeParam(String text) {

		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}

	}
	
	public static Instant convertData(String textDate, Instant defaultValue) {
		Instant aux;
		try {
			aux = Instant.parse(textDate);
			return aux;
		} 
		catch(DateTimeParseException e) {
			return defaultValue;
		}
		
	
	}

}
