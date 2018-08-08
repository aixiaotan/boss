package org.boss.hong.ademo.controller;

import org.boss.demo.dto.DemoDTO;
import org.boss.hong.ademo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo/")
public class DemoControllor {

	private static final Logger logger = LoggerFactory.getLogger(DemoControllor.class);
	
	@Autowired
	private DemoService demoService;
	
	@GetMapping(value = "user/userId/{userId}")
	public String getDemo(@RequestParam String userName,@PathVariable Integer userId) {
		logger.info("");
		DemoDTO dto = demoService.getDto(userId);
		dto.setUserName(userName);
		return dto.toString();
	}
}
