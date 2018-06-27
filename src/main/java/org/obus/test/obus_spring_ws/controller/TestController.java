package org.obus.test.obus_spring_ws.controller;

import java.util.Map;

import org.obus.test.obus_spring_ws.services.IKuliService;
import org.obus.test.obus_spring_ws.services.IkaryawanService;
import org.obus.test.obus_spring_ws.services.impl.KuliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	private String message = "hello world";

	@Autowired
	private IKuliService kuliService;
	
	@Autowired
	private IkaryawanService karyawanService;
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);

		System.out.println(kuliService.getKuliById(1).toString());
		System.out.println(karyawanService.findKaryawanById(2));
		
		return "welcome";
	}
}
