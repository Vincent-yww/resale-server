package com.hebeu.resale.demo1.mapper;

import com.hebeu.resale.demo1.domain.Users;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users queryOneByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    Users queryOneByUsernameAndPasswordAndCharacter(@Param("username") String username, @Param("password") String password, @Param("character") String character);

    Users queryOneByPhoneOrEmail(@Param("phone") String phone, @Param("email") String email);

    List<Users> queryByAll(Users users);

    int updateCharacterByUid(@Param("updatedCharacter") String updatedCharacter, @Param("uid") Integer uid);
}