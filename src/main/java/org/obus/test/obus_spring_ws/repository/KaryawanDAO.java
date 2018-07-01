package org.obus.test.obus_spring_ws.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		System.out.println("aaaaaaaaaaaaaaaaaa");
		try {
			System.out.println(id);
			return entityManager.find(Karyawan.class, id);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}

	@Override
	public List<Karyawan> findAllKaryawan() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery(
				"get Karyawan List", Karyawan.class);
		
		return query.getResultList();
	}

	@Override
	public int addkaryawan(Karyawan data) {
		// TODO Auto-generated method stub
		Karyawan a = new Karyawan();
		a.setId(4);
		a.setName("asdasdasd");
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(a);
			entityManager.getTransaction().commit();
			
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			return 1;
		}
	}

	@Override
	public int updateKaryawan(Karyawan data) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			karyawan.setId(data.getId());
			karyawan.setName(data.getName());
			entityManager.getTransaction().commit();
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			return 1;
		}
	}

	@Override
	public int removeKaryawan(int id) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			entityManager.find(Karyawan.class, id);
			entityManager.remove(karyawan);
			entityManager.getTransaction().commit();
			return 0;		
		}catch (Exception e) {
			// TODO: handle exception
			return 1;
		}

	}
}
