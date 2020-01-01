package com.hebeu.resale.demo1.service;

import com.hebeu.resale.demo1.domain.Users;import java.util.List;

public interface UsersService {

    int deleteByPrimaryKey(Integer uid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users queryOneByUsernameAndPassword(String username, String password);


    Users queryOneByPhoneOrEmail(String phone, String email);

    Users queryOneByUsernameAndPasswordAndCharacter(String username, String password, String character);

    List<Users> queryByAll(Users users);

    int updateCharacterByUid(String updatedCharacter, Integer uid);
}












