package com.hebeu.resale.demo1.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hebeu.resale.demo1.domain.School;
import com.hebeu.resale.demo1.mapper.SchoolMapper;
import com.hebeu.resale.demo1.service.SchoolService;import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Resource
    private SchoolMapper schoolMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return schoolMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(School record) {
        return schoolMapper.insert(record);
    }

    @Override
    public int insertSelective(School record) {
        return schoolMapper.insertSelective(record);
    }

    @Override
    public School selectByPrimaryKey(Integer id) {
        return schoolMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(School record) {
        return schoolMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(School record) {
        return schoolMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<School> queryByAll(School school) {
        return schoolMapper.queryByAll(school);
    }
}

