package org.obus.test.obus_spring_ws.endpoint;

import org.obus.test.obus_spring_ws.GetKuliRequest;
import org.obus.test.obus_spring_ws.GetKuliResponse;
import org.obus.test.obus_spring_ws.services.IKuliService;
import org.obus.test.obus_spring_ws.services.impl.KuliService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class KuliEndpoint {
	private static final String NAMESPACE_URI = "http://obus.org/test/obus-spring-ws";
	IKuliService kuliService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getKuliRequest")
	@ResponsePayload
	public GetKuliResponse getKuli(@RequestPayload GetKuliRequest request) {
		GetKuliResponse response = new GetKuliResponse();
		
		kuliService = new KuliService();
		
		response.setKuliInfo(kuliService.getKuliById(request.getId()));

		return response;
	}
}
