package org.boss.hong.user.mapper;

import org.boss.hong.user.dos.LoginUserDO;

public interface LoginUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginUserDO record);

    int insertSelective(LoginUserDO record);

    LoginUserDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginUserDO record);

    int updateByPrimaryKey(LoginUserDO record);
}