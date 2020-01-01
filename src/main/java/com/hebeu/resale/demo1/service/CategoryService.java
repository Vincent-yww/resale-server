package com.hebeu.resale.demo1.service;

import com.hebeu.resale.demo1.domain.Category;import java.util.List;

public interface CategoryService {


    int deleteByPrimaryKey(Integer cId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> queryByAll(Category category);

    List<Category> queryAll();
}




