package com.lohika.alp.howto.tests;

import java.sql.ResultSet;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.rendition.api.RenditionAPIException;
import com.rendition.api.Result;


public class ConnectDeviceAPI {
	
	Logger lg = Logger.getLogger(ConnectDeviceAPI.class);
	
	@Test(groups="ART")	
	public void ConnectToDevice() throws Exception, RenditionAPIException {

		lg.info("Inside ConnectToDevice test");		
		
		String command = "show user -u admin";
		lg.info(command);

		Result result = session.exec(command);
		assertTrue(command + " failed", result.getSucceeded());
		ResultSet user = result.getResultSet();

		if (user.next()) { // show user
			lg.info("UserID:" + user.getInt("UserID"));
			lg.info("FirstName:" + user.getString("FirstName"));
			lg.info("LastName:" + user.getString("LastName"));
			lg.info("EmailAddress:" + user.getString("EmailAddress"));
			lg.info("CreateDate:" + user.getTimestamp("CreateDate"));
			lg.info("Woohoo");
		} else {
			lg.error("No result");
		}
	}
}
