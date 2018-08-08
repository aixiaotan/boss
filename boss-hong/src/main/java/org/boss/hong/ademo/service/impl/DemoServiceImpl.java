package org.boss.hong.ademo.service.impl;

import org.boss.demo.dto.DemoDTO;
import org.boss.hong.ademo.mapper.DemoMapper;
import org.boss.hong.ademo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

//	@Autowired
//	private DemoMapper demoMapper;
	
	@Override
	public DemoDTO getDto(Integer userId) {
		DemoDTO dto = new DemoDTO();
		dto.setUserId(userId);
		return dto;
	}

	
} 
