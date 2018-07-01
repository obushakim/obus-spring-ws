package org.obus.test.obus_spring_ws.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.obus.test.obus_spring_ws.AddKaryawanRequest;
import org.obus.test.obus_spring_ws.AddKaryawanResponse;
import org.obus.test.obus_spring_ws.GetAllKaryawanResponse;
import org.obus.test.obus_spring_ws.GetKaryawanRequest;
import org.obus.test.obus_spring_ws.GetKaryawanResponse;
import org.obus.test.obus_spring_ws.KaryawanInfo;
import org.obus.test.obus_spring_ws.RemoveKaryawanRequest;
import org.obus.test.obus_spring_ws.RemoveKaryawanResponse;
import org.obus.test.obus_spring_ws.UpdateKaryawanRequest;
import org.obus.test.obus_spring_ws.UpdateKaryawanResponse;
import org.obus.test.obus_spring_ws.model.Karyawan;
import org.obus.test.obus_spring_ws.services.IkaryawanService;
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
		
		BeanUtils.copyProperties(
				karyawanService.findKaryawanById(request.getId()), karyawanInfo);
		
		response.setKaryawanInfo(karyawanInfo);

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllKaryawanRequest")
	@ResponsePayload
	public GetAllKaryawanResponse getAllKaryawan() {
		GetAllKaryawanResponse response = new GetAllKaryawanResponse();
		List<KaryawanInfo> karyawans = new ArrayList<>();
		List<Karyawan> listResult = karyawanService.findAllKaryawan();
		KaryawanInfo karyawanInfo = new KaryawanInfo();
		
		for (int i = 0; i < listResult.size(); i++) {
		     BeanUtils.copyProperties( 
		    		 listResult.get(i),
		    		 karyawanInfo);
		     karyawans.add(karyawanInfo);
		}
		
//		for(Karyawan item : listResult) {
//			KaryawanInfo karyawanInfo = new KaryawanInfo();
//			karyawanInfo.setId(item.getId());
//			karyawanInfo.setName(item.getName());
//			
//			karyawans.add(karyawanInfo);
//		}

		response.getKaryawanList().addAll(karyawans);

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addKaryawanRequest")
	@ResponsePayload
	public AddKaryawanResponse addKaryawan(@RequestPayload AddKaryawanRequest request) {
		AddKaryawanResponse response = new AddKaryawanResponse();
		Karyawan karyawan = new Karyawan();
		BeanUtils.copyProperties(
				request.getKaryawanInfo(), 
				karyawan);
		
		String responseStatus = karyawanService.addkaryawan(karyawan);
		response.setResponseStatus(responseStatus);;

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateKaryawanRequest")
	@ResponsePayload
	public UpdateKaryawanResponse addKaryawan(@RequestPayload UpdateKaryawanRequest request) {
		UpdateKaryawanResponse response = new UpdateKaryawanResponse();
		Karyawan karyawan = new Karyawan();
		BeanUtils.copyProperties(
				request.getKaryawanInfo(), 
				karyawan);
		
		String responseStatus = karyawanService.updateKaryawan(karyawan);
		response.setResponseStatus(responseStatus);;

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeKaryawanRequest")
	@ResponsePayload
	public RemoveKaryawanResponse addKaryawan(@RequestPayload RemoveKaryawanRequest request) {
		RemoveKaryawanResponse response = new RemoveKaryawanResponse();
		
		String responseStatus = karyawanService.deleteKaryawan(request.getId());
		response.setResponseStatus(responseStatus);;

		return response;
	}
}
