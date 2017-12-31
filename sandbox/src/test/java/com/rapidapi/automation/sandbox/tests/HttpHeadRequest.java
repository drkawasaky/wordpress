package com.rapidapi.automation.sandbox.tests;

import org.junit.Test;

import com.rapidapi.automation.sandbox.AbstractTestCase;
import com.rapidapi.automation.sandbox.web.HttpServicing;

public class HttpHeadRequest extends AbstractTestCase{

	@Test
	public void checkTheImageAvalable() throws Exception {
		
		String response = HttpServicing.performRequest();
		if(Integer.parseInt(response) > 0) {
			System.out.println("The file can be reached. The size of the file is: " + response);
		}else {
			System.out.println("The request failed. Please analyze the response headers: " + response);
		}
	}
}
