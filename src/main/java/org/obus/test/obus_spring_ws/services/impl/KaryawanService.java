package org.obus.test.obus_spring_ws.services.impl;

import java.util.List;
import java.util.Optional;

import org.obus.test.obus_spring_ws.model.Karyawan;
import org.obus.test.obus_spring_ws.repository.IKaryawanDAO;
import org.obus.test.obus_spring_ws.repository.IKaryawanDAODua;
import org.obus.test.obus_spring_ws.services.IkaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class KaryawanService implements IkaryawanService {
	@Autowired
	private IKaryawanDAO karyawanRepository;

	@Autowired
	private IKaryawanDAODua karyawanRepo;
	
	@Override
	public Karyawan findKaryawanById(int id) {
		// TODO Auto-generated method stub
		return karyawanRepo.findById(id).get();
	}

	@Override
	public List<Karyawan> findAllKaryawan() {
		// TODO Auto-generated method stub
		return karyawanRepo.findAll();
	}

	@Override
	public String addkaryawan(Karyawan data) {
		// TODO Auto-generated method stub
		try {
			Karyawan result = karyawanRepo.save(data);	
			return "success";
		} catch (Exception e) {
			return "fail";
		}
	}

	@Override
	public String updateKaryawan(Karyawan data) {
		// TODO Auto-generated method stub
		Optional<Karyawan> karyawan = karyawanRepo.findById(data.getId());

		if (karyawan.isPresent()) {
			karyawanRepo.save(data);

			return "success";
		} else {
			ResponseEntity.notFound().build();
			return "fail";
		}
	}

	@Override
	public String deleteKaryawan(int id) {
		// TODO Auto-generated method stub
		Optional<Karyawan> karyawan = karyawanRepo.findById(id);
		if (karyawan.isPresent()) {
			karyawanRepo.deleteById(id);
			return "success";
		} else {
			ResponseEntity.notFound().build();
			return "fail";
		}
	}
	
}
