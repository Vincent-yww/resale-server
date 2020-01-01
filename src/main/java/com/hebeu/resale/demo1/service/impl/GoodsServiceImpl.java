package com.hebeu.resale.demo1.service.impl;

import com.hebeu.resale.demo1.vo.QueryGoodsVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hebeu.resale.demo1.mapper.GoodsMapper;
import com.hebeu.resale.demo1.domain.Goods;
import com.hebeu.resale.demo1.service.GoodsService;import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public int deleteByPrimaryKey(Integer gId) {
        return goodsMapper.deleteByPrimaryKey(gId);
    }

    @Override
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    @Override
    public int insertSelective(Goods record) {
        return goodsMapper.insertSelective(record);
    }

    @Override
    public Goods selectByPrimaryKey(Integer gId) {
        return goodsMapper.selectByPrimaryKey(gId);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Goods record) {
        return goodsMapper.updateByPrimaryKey(record);
    }


    @Override
    public List<Goods> queryByAll(Goods goods) {
        return goodsMapper.queryByAll(goods);
    }

    @Override
    public List<Goods> queryAllByCategory(Integer category) {
        return goodsMapper.queryAllByCategory(category);
    }



    @Override
    public List<Goods> queryAllByCategoryAndSchoolAndNameLike(Integer category, Integer school, String likeName) {
        return goodsMapper.queryAllByCategoryAndSchoolAndNameLike(category, school, likeName);
    }

    @Override
    public QueryGoodsVo queryV0(Integer id) {
        return goodsMapper.queryV0(id);
    }
}










