package com.lohika.alp.utils;

public class Environment {
	
	private static String AUTLink = "https://134.44.97.170/";
	private static String SeleniumServerURL = "http://localhost:4444/wd/hub";
	private static String username = "admin";
	private static String pass = "pass";
	

	public static String getAUTLink() {
		return AUTLink;
	}

	public static String getServerURL() {
		return SeleniumServerURL;
		
	}

	public static String getUsername() {
		return username;
	}

	public static String getPass(){
		return pass;
	}

	
	}
