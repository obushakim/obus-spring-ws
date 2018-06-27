package org.obus.test.obus_spring_ws.repository;

import org.obus.test.obus_spring_ws.model.Karyawan;

public interface IKaryawanDAO {
	public Karyawan findKaryawan(int id);
}
