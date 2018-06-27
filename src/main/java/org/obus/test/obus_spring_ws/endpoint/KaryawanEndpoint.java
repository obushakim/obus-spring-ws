package org.obus.test.obus_spring_ws.endpoint;

import org.obus.test.obus_spring_ws.GetKaryawanRequest;
import org.obus.test.obus_spring_ws.GetKaryawanResponse;
import org.obus.test.obus_spring_ws.KaryawanInfo;
import org.obus.test.obus_spring_ws.services.IkaryawanService;
import org.obus.test.obus_spring_ws.services.impl.KaryawanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class KaryawanEndpoint {
	private static final String NAMESPACE_URI = "http://obus.org/test/obus-spring-ws";
	@Autowired
	private IkaryawanService karyawanService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getKaryawanRequest")
	@ResponsePayload
	public GetKaryawanResponse getKaryawan(@RequestPayload GetKaryawanRequest request) {
		GetKaryawanResponse response = new GetKaryawanResponse();
		
		KaryawanInfo karyawanInfo = new KaryawanInfo();
		
		BeanUtils.copyProperties(karyawanService.findKaryawanById(request.getId()), karyawanInfo);
		
		response.setKaryawanInfo(karyawanInfo);

		return response;
	}
}
