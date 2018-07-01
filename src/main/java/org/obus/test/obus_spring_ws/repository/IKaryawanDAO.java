package org.obus.test.obus_spring_ws.repository;

import java.util.List;

import org.obus.test.obus_spring_ws.model.Karyawan;

public interface IKaryawanDAO {
	public Karyawan findKaryawan(int id);
	public List<Karyawan> findAllKaryawan();
	public int addkaryawan(Karyawan data);
	public int updateKaryawan(Karyawan data);
	public int removeKaryawan(int id);
	
}
