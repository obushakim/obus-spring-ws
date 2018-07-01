package org.obus.test.obus_spring_ws.repotest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.obus.test.obus_spring_ws.AppTest;
import org.obus.test.obus_spring_ws.model.Karyawan;
import org.obus.test.obus_spring_ws.services.IkaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class DaoTest extends AppTest {
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private IkaryawanService service;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void findByIdTest() throws Exception {
		Karyawan result = service.findKaryawanById(1);
		assertEquals("obus", result.getName());
	}
	
	@Test
	public void findAllTest() throws Exception {
		List<Karyawan> result = service.findAllKaryawan();
		
		assertEquals("obus", result.get(0).getName());
	}
	
	@Ignore
	@Test
	public void addTest() throws Exception {
		Karyawan karyawan = new Karyawan();
		karyawan.setName("babi");
		String result = service.addkaryawan(karyawan);
		assertEquals("success", result);
	}
	
	@Ignore
	@Test
	public void updateTest() throws Exception {
		Karyawan karyawan = new Karyawan();
		karyawan.setId(3);
		karyawan.setName("monyet");
		String result = service.updateKaryawan(karyawan);
		assertEquals("success", result);
	}
	
	@Ignore
	@Test
	public void deleteTest() throws Exception {
		String result = service.deleteKaryawan(3);
		assertEquals("success", result);
	}
		
}
