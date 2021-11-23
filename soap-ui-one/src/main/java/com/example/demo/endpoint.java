package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.gs_producing_web_service.GetCountryRequest;
import com.example.demo.gs_producing_web_service.GetCountryResponse;

@Endpoint
public class endpoint {
	private static final String NAMESPACE_URI = "http://www.example.com/demo/gs-producing-web-service";

	private Repository countryRepository;

	@Autowired
	public endpoint(Repository Repository) {
		this.countryRepository = Repository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}

}
