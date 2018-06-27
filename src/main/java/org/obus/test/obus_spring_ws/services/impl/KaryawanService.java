package org.obus.test.obus_spring_ws.services.impl;

import org.obus.test.obus_spring_ws.model.Karyawan;
import org.obus.test.obus_spring_ws.repository.IKaryawanDAO;
import org.obus.test.obus_spring_ws.repository.KaryawanDAO;
import org.obus.test.obus_spring_ws.services.IkaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KaryawanService implements IkaryawanService {
	@Autowired
	private IKaryawanDAO karyawanRepository;
	
	@Override
	public Karyawan findKaryawanById(int id) {
		// TODO Auto-generated method stub
		
		return karyawanRepository.findKaryawan(id);
	}
	
}
