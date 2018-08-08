package org.boss.hong.user.service.impl;

import org.boss.hong.user.dos.LoginUserDO;
import org.boss.hong.user.mapper.LoginUserMapper;
import org.boss.hong.user.service.LoginUserService;
import org.boss.user.dto.LoginUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements LoginUserService{
	
	@Autowired
	private LoginUserMapper loginUserMapper;

	@Override
	public LoginUserDTO loginUser(Integer id) {
		LoginUserDO loginUserDO = loginUserMapper.selectByPrimaryKey(id);
		if(null != loginUserDO) {
			LoginUserDTO loginUserDTO = new LoginUserDTO();
			BeanUtils.copyProperties(loginUserDO, loginUserDTO);
			return loginUserDTO;
		}
		return null;
	}

}
