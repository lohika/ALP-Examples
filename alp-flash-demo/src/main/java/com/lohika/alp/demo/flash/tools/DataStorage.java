package com.lohika.alp.demo.flash.tools;

public class DataStorage {

	private String linkToEnv1;
	private String linkToEnv2;

	public DataStorage() {
		linkToEnv1 = "http://alp-server:8080/FlashAUT/Flexcaster.html";
		linkToEnv2 = "http://youtube.com/";
	}

	public String getEnv1() {
		return linkToEnv1;
	}

	public String getEnv2() {
		return linkToEnv2;
	}

}
