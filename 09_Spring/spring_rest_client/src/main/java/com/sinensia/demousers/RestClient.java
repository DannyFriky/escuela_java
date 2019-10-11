package com.sinensia.demousers;

import javax.xml.ws.soap.AddressingFeature.Responses;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {
	
	private static final String URL_SRV_87 ="http://172.16.4.60:8087";

	private RestTemplate rest;
	private HttpHeaders header;
	private HttpStatus status;
	
	public RestClient() {
		this.rest = new RestTemplate();
		this.header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		header.add("Accept", "*/*");
	}
	
	public String get(String uri) {
		HttpEntity<String> requestEntiti = new HttpEntity<String>("",header);
		ResponseEntity<String> responseEntity=
				rest.exchange(URL_SRV_87 + uri, HttpMethod.GET,requestEntiti,String.class);
		this.status= responseEntity.getStatusCode();
		return responseEntity.getBody();
	}
}
