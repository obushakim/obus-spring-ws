package org.obus.test.obus_spring_ws.services.impl;

import org.obus.test.obus_spring_ws.KuliInfo;
import org.obus.test.obus_spring_ws.services.IKuliService;
import org.springframework.stereotype.Service;

@Service
public class KuliService implements IKuliService {

	@Override
	public KuliInfo getKuliById(int id) {
		// TODO Auto-generated method stub
		KuliInfo kuli = new KuliInfo();
		kuli.setName("tai");
		kuli.setId(1);
		
		return kuli;
	}
		
}
