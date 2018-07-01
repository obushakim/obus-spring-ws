package org.obus.test.obus_spring_ws.repository;

import java.util.List;

import org.obus.test.obus_spring_ws.model.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKaryawanDAODua extends JpaRepository<Karyawan, Integer> {

}
