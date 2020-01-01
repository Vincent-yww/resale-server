package com.hebeu.resale.demo1.service;

import com.hebeu.resale.demo1.domain.School;import java.util.List;

public interface SchoolService {


    int deleteByPrimaryKey(Integer id);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);

    List<School> queryByAll(School school);
}

