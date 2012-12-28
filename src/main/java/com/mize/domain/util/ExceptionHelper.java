package com.mize.domain.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionHelper {
	
	public static String getStackTraceAsString(Exception e){
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}
}
