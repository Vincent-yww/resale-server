package com.hebeu.resale.demo1.service.impl;

import com.hebeu.resale.demo1.domain.Category;
import com.hebeu.resale.demo1.mapper.CategoryMapper;
import com.hebeu.resale.demo1.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer cId) {
        return categoryMapper.deleteByPrimaryKey(cId);
    }

    @Override
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }

    @Override
    public Category selectByPrimaryKey(Integer cId) {
        return categoryMapper.selectByPrimaryKey(cId);
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Category> queryByAll(Category category) {
        return categoryMapper.queryByAll(category);
    }

    @Override
    public List<Category> queryAll() {
        return categoryMapper.queryAll();
    }
}




