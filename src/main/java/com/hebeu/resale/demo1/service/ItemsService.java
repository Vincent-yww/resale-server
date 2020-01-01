package com.hebeu.resale.demo1.service;

import com.hebeu.resale.demo1.domain.Items;

import java.util.List;

public interface ItemsService  {


    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(Items record);

    List<Items> queryByAllOrderByName(Items items);
}



