package com.lohika.alp.utils;

/**
 * 
 * @author Smorodsky Anton
 * 
 *         This is basic implementation of class that get dynamic data for our
 *         tests . In real-world cases data should came not from static strings
 *         but from any place that can be edited without recompiling hole suite
 *         . For example - java *.properties , *.csv , ordinary *.txt files and
 *         etc.
 * 
 */

public class Environment {

	private static String AUTLink = "http://www.facebook.com/"; // link to ApplicationUnderTest (facebook.com in our case)
	private static String SeleniumServerURL = "http://localhost:4444/wd/hub"; // link where Selenium Server running
	private static String username = "alptester2011@gmail.com"; // correct facebook username
	private static String pass = "pw123456"; // coorect facebook password
	private static String usernameWrong = "alptester12011@gmail.com"; // non-exsisting username
	private static String passWrong = "pw1234516"; // non-existing password
	private static String username_displayed = "Anton Medvedev"; // Used to check PositiveLogin 

	/**
	 * 
	 * Range of getters that return data . Can be easily modified to return it
	 * not from static string but read it from txt file for example.
	 */
	public static String getAUTLink() {
		return AUTLink;
	}

	public static String getServerURL() {
		return SeleniumServerURL;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPass() {
		return pass;
	}

	public static String getUsernameWrong() {
		return usernameWrong;
	}

	public static String getPassWrong() {
		return passWrong;
	}

	public static String getUsername_displayed() {
		return username_displayed;
	}

}
