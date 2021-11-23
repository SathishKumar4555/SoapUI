package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.OverallRepo.OverallRepository;
import com.example.demo.gs_producing_web_service.GetOverallRequest;
import com.example.demo.gs_producing_web_service.GetOverallResponse;

@Endpoint
public class Overallendpoint {
	private static final String NAMESPACE_URI = "http://www.example.com/demo/gs-producing-web-service";

	private OverallRepository over;

	@Autowired
	public void endpoint(OverallRepository OverallRepository) {
		this.over = OverallRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOverallRequest")
	@ResponsePayload
	public GetOverallResponse getOverall(@RequestPayload GetOverallRequest request) {
		GetOverallResponse response = new GetOverallResponse();
		response.setOverall((over).findOverall(request.getName()));

		return response;
	}

}
