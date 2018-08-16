package org.boss.hong.user.service.impl;

import org.boss.hong.user.dos.LoginUserDO;
import org.boss.hong.user.mapper.LoginUserMapper;
import org.boss.hong.user.service.LoginUserService;
import org.boss.hong.util.RedisUtil;
import org.boss.user.dto.LoginUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class LoginUserServiceImpl implements LoginUserService{
	
	@Autowired
	private LoginUserMapper loginUserMapper;
	@Autowired
	private RedisUtil redisUtil;

	@Override
	public LoginUserDTO loginUser(Integer id) {
		if(id == 2) {
			String str = redisUtil.get(id+"");
			if(str != null && str.length() != 0) {
				LoginUserDTO dto = JSONObject.parseObject(str, LoginUserDTO.class);
				return dto;
			}
		}
		LoginUserDO loginUserDO = loginUserMapper.selectByPrimaryKey(id);
		if(null != loginUserDO) {
			LoginUserDTO loginUserDTO = new LoginUserDTO();
			BeanUtils.copyProperties(loginUserDO, loginUserDTO);
			LoginUserDTO d2 = new LoginUserDTO();
			BeanUtils.copyProperties(loginUserDO, d2);
			d2.setLoginPhoneNumber("12222222222222222");
			d2.setWechatUserInfo("改变了内容了");
			redisUtil.set(id+"", JSONObject.toJSONString(d2));
			return loginUserDTO;
		}
		return null;
	}

}
