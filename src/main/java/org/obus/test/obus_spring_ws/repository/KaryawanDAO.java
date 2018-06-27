package org.obus.test.obus_spring_ws.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.obus.test.obus_spring_ws.model.Karyawan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class KaryawanDAO implements IKaryawanDAO {
	private static final Map<Integer, Karyawan> karyawans = new HashMap<>();
	Karyawan karyawan;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	public void initData() {
		Karyawan obus = new Karyawan();
		obus.setId(1);
		obus.setName("obus");
		
		karyawans.put(1, obus);
	}
	
	@Override
	public Karyawan findKaryawan(int id) {
		karyawans.get(id);
		karyawan = entityManager.find(Karyawan.class, id);
		
		
		return karyawan;
	}
}
