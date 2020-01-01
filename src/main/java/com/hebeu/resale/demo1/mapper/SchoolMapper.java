package com.hebeu.resale.demo1.mapper;

import com.hebeu.resale.demo1.domain.School;
import java.util.List;

public interface SchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);

    List<School> queryByAll(School school);
}