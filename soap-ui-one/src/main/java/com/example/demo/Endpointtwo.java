package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.gs_producing_web_service.GetCapitalRequest;
import com.example.demo.gs_producing_web_service.GetCapitalResponse;

@Endpoint
public class Endpointtwo {
	private static final String NAMESPACE_URI = "http://www.example.com/demo/gs-producing-web-service";

	private repositorytwo capitalRepository;

	@Autowired
	public void Endpoint(repositorytwo repositorytwo) {
		this.capitalRepository = repositorytwo;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCapitalRequest")
	@ResponsePayload
	public GetCapitalResponse getCapital(@RequestPayload GetCapitalRequest request) {
		GetCapitalResponse response = new GetCapitalResponse();
		response.setCapital(capitalRepository.findCapital(request.getName()));

		return response;
	}
}
