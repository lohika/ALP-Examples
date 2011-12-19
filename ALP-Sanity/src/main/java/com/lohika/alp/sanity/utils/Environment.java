package com.lohika.alp.sanity.utils;

public class Environment {

	private static String hubURL = "http://localhost:4444/wd/hub";
	private static String get = "http://www.google.com";
	private static String get2 = "http://ya.ru";
	private static String inputcheckboxes = "http://www.htmldog.com/examples/inputcheckboxes.html";
	private static String forms1 = "http://www.htmldog.com/examples/select1.html";
	private static String forms2 = "http://www.htmldog.com/examples/textarea.html";
	private static String jsCatcherEnv = "http://lohika.github.com/ALP/test";
	
	public static String getJsCatcherEnv() {
		return jsCatcherEnv;
	}

	public static String getGet() {
		return get;
	}

	public static String getGet2() {
		return get2;
	}

	public static String getInputcheckboxes() {
		return inputcheckboxes;
	}

	public static String getHubURL() {
		return hubURL;
	}

	public static String getforms1() {
		return forms1;
	}

	public static String getforms2() {
		return forms2;
	}

}
