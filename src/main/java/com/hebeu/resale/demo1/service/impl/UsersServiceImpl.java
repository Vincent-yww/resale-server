package com.hebeu.resale.demo1.service.impl;

import com.hebeu.resale.demo1.domain.Users;
import com.hebeu.resale.demo1.mapper.UsersMapper;
import com.hebeu.resale.demo1.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;import java.util.List;


@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return usersMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public int insert(Users record) {
        return usersMapper.insert(record);
    }

    @Override
    public int insertSelective(Users record) {
        return usersMapper.insertSelective(record);
    }

    @Override
    public Users selectByPrimaryKey(Integer uid) {
        return usersMapper.selectByPrimaryKey(uid);
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Users record) {
        return usersMapper.updateByPrimaryKey(record);
    }

    @Override
    public Users queryOneByUsernameAndPassword(String username, String password) {
        return usersMapper.queryOneByUsernameAndPassword(username, password);
    }


    @Override
    public Users queryOneByPhoneOrEmail(String phone, String email) {
        return usersMapper.queryOneByPhoneOrEmail(phone, email);
    }

    @Override
    public Users queryOneByUsernameAndPasswordAndCharacter(String username, String password, String character) {
        return usersMapper.queryOneByUsernameAndPasswordAndCharacter(username, password, character);
    }

    @Override
    public List<Users> queryByAll(Users users) {
        return usersMapper.queryByAll(users);
    }

    @Override
    public int updateCharacterByUid(String updatedCharacter, Integer uid) {
        return usersMapper.updateCharacterByUid(updatedCharacter, uid);
    }
}












