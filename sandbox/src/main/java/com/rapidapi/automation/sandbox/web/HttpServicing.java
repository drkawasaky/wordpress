package com.rapidapi.automation.sandbox.web;

import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpServicing {


	private static OkHttpClient okHttpClient = null;

	static {

		okHttpClient = new OkHttpClient.Builder()
				.connectTimeout(10, TimeUnit.SECONDS)
				.writeTimeout(10, TimeUnit.SECONDS)
				.readTimeout(30, TimeUnit.SECONDS)
				.build();
	}

	public static String performRequest() throws Exception {

		String serviceUrl = "http://the-internet.herokuapp.com/download_secure/picture.jpg";
		String credential = Credentials.basic("admin", "admin");

		Request request = new Request.Builder()
				.url(serviceUrl)
				.header("Authorization", credential)
				.head()
				.build();

		Response response = okHttpClient.newCall(request).execute();

		String responseHeaders = response.headers().toString();
		String contentSize = response.header("Content-Length");
		
		if((response.code() == 200)) {
			return contentSize;
		}

		return responseHeaders;
	}
}
