package org.obus.test.obus_spring_ws.services;

import java.util.List;

import org.obus.test.obus_spring_ws.model.Karyawan;

public interface IkaryawanService {
	public Karyawan findKaryawanById(int id);
	public List<Karyawan> findAllKaryawan();
	public String addkaryawan(Karyawan data);
	public String updateKaryawan(Karyawan data);
	public String deleteKaryawan(int id);
	
}
