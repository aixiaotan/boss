package org.boss.hong.user.controller;

import org.boss.hong.user.service.LoginUserService;
import org.boss.user.dto.LoginUserDTO;
import org.boss.user.vo.LoginUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关
 * @author peiHongWei
 *
 * 2018年8月8日
 */
@RestController
@RequestMapping(value = "/user")
public class LoginUserController {

	@Autowired 
	private LoginUserService loginUserService;
	 
	@GetMapping(value = "/loginUser/userId/{userId}")
	public LoginUserVO loginUser(@PathVariable Integer userId) {
		LoginUserVO loginUserVO = new LoginUserVO();
		LoginUserDTO loginUserDTO = loginUserService.loginUser(userId);
		if(loginUserDTO != null) {
			BeanUtils.copyProperties(loginUserDTO, loginUserVO);
		}
		return loginUserVO;
	}
}
