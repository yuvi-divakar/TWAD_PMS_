package com.raavan.twad.Util;

import java.util.regex.Pattern;

public class Util {

	private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

	  public static boolean isNumeric(String strNum) {
	      if (strNum == null) {
	          return false; 
	      }
	      return pattern.matcher(strNum).matches();
	  }
}
